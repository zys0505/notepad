
package com.zys.notepad.repository;


import com.zys.notepad.model.Message;

public interface MessageRepository {

	Iterable<Message> findAll();

	Message save(Message message);

	Message findMessage(Long id);

	void deleteMessage(Long id);

}
