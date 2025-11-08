package org.chat;
import java.util.*;

public class chatbot {

	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		System.out.println("===WELCOME TO ATOZEECHBOT===\n");
		System.out.println("How can i Call you:");
		String name=scan.nextLine();
		System.out.println("Chatbot🤖🧠🇦🇮👾: Hello, i am your ATOZEE BOT. Type 'SEE YOU' to end the chat");
		
		boolean chat_continue=true;
		 
		while(chat_continue) {
			System.out.print("You: ");
			String userinput=scan.nextLine().toLowerCase();
			
			if(userinput.contains("hi")|| userinput.contains("hello")) {
				System.out.println("Chatbot🤖🧠🇦🇮👾: Hi " + name + " ! How can I help you today?");
				
			}
			else if(userinput.contains("how are you")) {
				System.out.println("Chatbot🤖🧠🇦🇮👾: I am doing great!! What about you " + name);
				
				
			}
			else if(userinput.contains("i am doing great")|| userinput.contains("i am fine")) {
				System.out.println("Chatbot🤖🧠🇦🇮👾: That's nice");
				
				
			}
			else if (userinput.contains("time")) {
                System.out.println("Chatbot🤖🧠🇦🇮👾: The current time is " + new Date());
            } 
			
			else if (userinput.contains("what is java")) {
                System.out.println("Chatbot🤖🧠🇦🇮👾: Java is a high-level, object-oriented programming language that is used to build all kinds of software — from simple apps to huge enterprise systems, Android apps, and even backend servers.");
			}
			
			else if (userinput.contains("see you")) {
	            System.out.println("Chatbot🤖🧠🇦🇮👾: Goodbye! Have a great day " + name + " 😊");
	            chat_continue=false;
	            break;
			
			
		}
		

	}
		scan.close();
		
	}
	

}



