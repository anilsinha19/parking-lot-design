package com.gojek.sample.parking.ui.console;

public interface CommandHandler {

	Command invoke(String cmdName);

}