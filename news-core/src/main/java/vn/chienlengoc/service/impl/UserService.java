package vn.chienlengoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.chienlengoc.converter.UserConverter;
import vn.chienlengoc.core.entity.UserEntity;
import vn.chienlengoc.core.repository.UserRepository;
import vn.chienlengoc.dto.UserDTO;
import vn.chienlengoc.service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserConverter userConverter;

	@Override
	public UserDTO findOneByUserName(String userName) {
		UserEntity userEntity = userRepository.findOneByUserName(userName);
		UserDTO userDTO = userConverter.convertToDto(userEntity);
		return userDTO;
	}
}
