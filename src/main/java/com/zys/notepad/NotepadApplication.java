package com.zys.notepad;

import com.zys.notepad.model.Message;
import com.zys.notepad.repository.InMemoryMessageRepository;
import com.zys.notepad.repository.MessageRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;

@SpringBootApplication
public class NotepadApplication {


	@Bean
	public MessageRepository messageRepository() {
		return new InMemoryMessageRepository();
	}

	@Bean
	public Converter<String, Message> messageConverter() {
		return new Converter<String, Message>() {
			@Override
			public Message convert(String id) {
				return messageRepository().findMessage(Long.valueOf(id));
			}
		};
	}
	public static void main(String[] args) {
		SpringApplication.run(NotepadApplication.class, args);
	}
}
