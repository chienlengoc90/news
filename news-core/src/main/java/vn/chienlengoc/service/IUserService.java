package vn.chienlengoc.service;

import vn.chienlengoc.dto.UserDTO;

public interface IUserService {
	UserDTO findOneByUserName(String userName);
}
