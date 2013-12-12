package com.innominds.bo;

import com.innominds.model.User;

public interface UserBo {

	void save ( User user );
	void update ( User user);
	void delete ( User user );
	User FindUser ( String UserName );
}
