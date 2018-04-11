package edu.curso.entidades;

import java.util.Date;

import javax.swing.JOptionPane;

public class TesteBO {

	public static void main(String[] args) {
		BO b1 = new BO();
		b1.setId(1);
		b1.setNome("Fernando Morgado");
		b1.setNumero("00001");
		b1.setRg("1234567-9");
		b1.setDataOcorrencia( new Date() );
		
		JOptionPane.showMessageDialog(null, b1 );

	}

}
