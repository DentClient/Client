package net.dent.client.command;

public interface Command {

	boolean run(String[] args);

	String[] usage();

}
