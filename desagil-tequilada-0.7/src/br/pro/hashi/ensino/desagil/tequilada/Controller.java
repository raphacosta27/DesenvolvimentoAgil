package br.pro.hashi.ensino.desagil.tequilada;

import java.awt.event.ActionListener;


public class Controller implements ActionListener {
	  private View view;

	  public Controller(View view) {
	    this.view = view;
	  }

	  @Override
	  public void actionPerformed(ActionEvent event) {
		  cpuPlayer.move(0, -1);
		  repaint();
	  }
	}