package net.sourcecodeexamples.java.search;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Main {

	public static void main(String[] args) throws ParseException {

		// convert String to Date
		String date = "1-Aug-2020 08:22:34 GMT";
		DateFormat simpleDateFormatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss zzz");
		Date dateSimpleFormatted = simpleDateFormatter.parse(date);
		// convert Date to String
		String dateAsDefaultString = dateSimpleFormatted.toString();
		String dateAsFormattedString = simpleDateFormatter.format(dateSimpleFormatted);
		System.out.println("Default format: " + dateAsDefaultString);
		System.out.println("Explicit format: " + dateAsFormattedString);

		System.out.println("\nJava 8, convert without formatter:");

		// convert String to LocalDate
		LocalDate localDate = LocalDate.parse("2020-07-01");
		// convert LocalDate to String
		String localDateAsDefaultString = localDate.toString();
		System.out.println("LocalDate: " + localDateAsDefaultString + "( year: " + localDate.getYear() + ", month: "
				+ localDate.getMonthValue() + ", day: " + localDate.getDayOfMonth() + " )");

		LocalTime localTime = LocalTime.parse("12:23:44");
		// convert LocalTime to String
		String localTimeAsDefaultString = localTime.toString();
		System.out.println("LocalTime: " + localTimeAsDefaultString + "( hour: " + localTime.getHour() + ", minute: "
				+ localTime.getMinute() + ", second: " + localTime.getSecond() + " )");

		// convert String to LocalDateTime
		LocalDateTime localDateTime = LocalDateTime.parse("2020-06-01T11:20:15");
		// convert LocalDateTime to String
		String localDateTimeAsDefaultString = localDateTime.toString();
		System.out.println("LocalDateTime: " + localDateTimeAsDefaultString + "( year: " + localDateTime.getYear()
				+ ", month: " + localDateTime.getMonthValue() + ", day: " + localDateTime.getDayOfMonth() + ", hour: "
				+ localDateTime.getHour() + ", minute: " + localDateTime.getMinute() + ", second: "
				+ localDateTime.getSecond() + " )");

		// convert String to ZonedDateTime
		ZonedDateTime zonedDateTime = ZonedDateTime.parse("2020-06-01T10:15:30+09:00[Asia/Tokyo]");
		// convert ZonedDateTime to String
		String zonedDateTimeAsDefaultString = zonedDateTime.toString();
		System.out.println("ZonedDateTime: " + zonedDateTimeAsDefaultString + "( year: " + zonedDateTime.getYear()
				+ ", month: " + zonedDateTime.getMonthValue() + ", day: " + zonedDateTime.getDayOfMonth() + ", hour: "
				+ zonedDateTime.getHour() + ", minute: " + zonedDateTime.getMinute() + ", second: "
				+ zonedDateTime.getSecond() + ", offset: " + zonedDateTime.getOffset() + ", zone: "
				+ zonedDateTime.getZone() + " )");

		System.out.println("\nJava 8, convert with formatter:");

		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		// convert String to LocalDate
		LocalDate localDateFormatted = LocalDate.parse("01.06.2020", dateFormatter);
		// convert LocalDate to String
		String localDateAsFormattedString = dateFormatter.format(localDateFormatted);
		System.out
				.println("Date: " + localDateAsFormattedString + "( year: " + localDateFormatted.getYear() + ", month: "
						+ localDateFormatted.getMonthValue() + ", day: " + localDateFormatted.getDayOfMonth() + " )");

		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH|mm|ss");
		// convert String to LocalTime
		LocalTime localTimeFormatted = LocalTime.parse("12|23|44", timeFormatter);
		// convert LocalTime to String
		String localTimeAsFormattedString = timeFormatter.format(localTimeFormatted);
		System.out.println("Time: " + localTimeAsFormattedString + "( hour: " + localTimeFormatted.getHour()
				+ ", minute: " + localTimeFormatted.getMinute() + ", second: " + localTimeFormatted.getSecond() + " )");

		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy, HH:mm:ss");
		// convert String to LocalDateTime
		LocalDateTime localDateTimeFormatted = LocalDateTime.parse("01.06.2020, 11:20:15", dateTimeFormatter);
		// convert LocalDateTime to String
		String localDateTimeAsFormattedString = dateTimeFormatter.format(localDateTimeFormatted);
		System.out.println("DateTime: " + localDateTimeAsFormattedString + "( year: " + localDateTimeFormatted.getYear()
				+ ", month: " + localDateTimeFormatted.getMonthValue() + ", day: "
				+ localDateTimeFormatted.getDayOfMonth() + ", hour: " + localDateTimeFormatted.getHour() + ", minute: "
				+ localDateTimeFormatted.getMinute() + ", second: " + localDateTimeFormatted.getSecond() + " )");
	}
}