package vn.chienlengoc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.chienlengoc.constant.CustomMessages;
import vn.chienlengoc.converter.UserConverter;
import vn.chienlengoc.core.entity.UserEntity;
import vn.chienlengoc.core.repository.UserRepository;
import vn.chienlengoc.dto.MyUserDetail;
import vn.chienlengoc.dto.RoleDTO;
import vn.chienlengoc.dto.UserDTO;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	private final Logger log = Logger.getLogger(CustomUserDetailsService.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserConverter userConverter;

	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) {
		UserEntity userEntity = userRepository.findOneByUserName(username);
		UserDTO userDTO = userConverter.convertToDto(userEntity);
		
		if(userDTO == null) {
			log.error(CustomMessages.ERR_USER_NOT_FOUND);
			throw new UsernameNotFoundException(CustomMessages.ERR_USER_NOT_FOUND);
		}
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (RoleDTO role: userDTO.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getCode()));			
		}
		
		MyUserDetail myUserDetail = new MyUserDetail(username, userDTO.getPassword(), true, true, true, true, authorities);
		BeanUtils.copyProperties(userDTO, myUserDetail);
		return myUserDetail;
	}
}
