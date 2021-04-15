package com.example.javabasic;

import java.io.IOException;

public class IoExceptionEx {

	void m() throws IOException {
		
			throw new IOException("Device Error");
		
	}

	void n() throws IOException{
		m();
	}

	void p() {
		try {
			n();
		}catch(NumberFormatException | IOException e) {
			System.err.println("Exception handled");
		}finally {
			System.out.println("Reached the finally block");
		}
//		} catch (IOException e) {
////			System.out.println("Exception handled");
//		}
	}

	public static void main(String args[]) {
		IoExceptionEx ex1 = new IoExceptionEx();
		ex1.p();

		System.out.println("End of the program");
	}
}
