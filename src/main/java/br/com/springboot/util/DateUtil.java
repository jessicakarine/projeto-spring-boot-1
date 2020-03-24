package br.com.springboot.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Component
@Repository
@Service
public class DateUtil {

	public String formatLocalDateTimeToDatabaseStyle(LocalDateTime localDateTime) {
		return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(localDateTime);
	}

}
