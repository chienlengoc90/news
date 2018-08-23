package vn.chienlengoc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

	@Override
	public List<UserDTO> getUsers(String userName, Pageable pageable) {
		Page<UserEntity> newsPage = null;
		if (userName != null) {
			newsPage = userRepository.findByUserNameContainingIgnoreCase(userName, pageable);
		} else {
			newsPage = userRepository.findAll(pageable);
		}
		List<UserEntity> newsEntities = newsPage.getContent();
		List<UserDTO> result = new ArrayList<UserDTO>();
		for (UserEntity userEntity : newsEntities) {
			UserDTO userDTO = userConverter.convertToDto(userEntity);
			result.add(userDTO);
		}
		return result;
	}

	@Override
	public int getTotalItems(String userName) {
		int totalItem = 0;
		if (userName != null) {
			totalItem = (int) userRepository.countByUserNameContainingIgnoreCase(userName);
		} else {
			totalItem = (int) userRepository.count();
		}
		return totalItem;
	}

	@Override
	public UserDTO insert(UserDTO userDTO) {
		UserEntity userEntity = userConverter.convertToEntity(userDTO);
		userEntity = userRepository.save(userEntity);
		return userConverter.convertToDto(userEntity);

	}
}
