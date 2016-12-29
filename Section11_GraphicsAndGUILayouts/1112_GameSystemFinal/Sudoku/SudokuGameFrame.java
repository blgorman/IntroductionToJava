/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import java.io.*;

/**
 *
 * @author MajorGuidance
 */
public class SudokuGameFrame extends JInternalFrame {
    JPanel _gamePanel;
    JPanel _innerBoard;
    
    JPanel panel1;
    JPanel panel2;
    JPanel panel3;
    JPanel panel4;
    JPanel panel5;
    JPanel panel6;
    JPanel panel7;
    JPanel panel8;
    JPanel panel9;
    
    SudokuGrid _gameGrid;
    
    int _difficultyLevel;
    JCheckBoxMenuItem menuDifficultyEasiest;
    JCheckBoxMenuItem menuDifficultyEasy;
    JCheckBoxMenuItem menuDifficultyMedium;
    JCheckBoxMenuItem menuDifficultyHard;
    
    private boolean _allowHintColoring;
    private Color goodGreenColor = new Color(0,139,0);
    private Color badRedColor = new Color(220,20,60);
    private String _saveRestorePath = "SudokuSaveState.bin";
    
    public SudokuGameFrame()
    {
        SetupForm();
    }
    
    /**
     * Create the game board
     */
    private void SetupForm(){
        setBackground(Color.WHITE);
        setClosable(true);
        setMaximizable(true);
        setResizable(false);
        
        //entire game panel:
        _gamePanel = new JPanel();
        _gamePanel.setLayout(null);
        
        //game menu bar
        JMenuBar sudokuMenuBar = new JMenuBar();
        sudokuMenuBar.setBounds(0, 0, 675, 25);
        _gamePanel.add(sudokuMenuBar);
        
        JMenu menuActions = new JMenu("Actions");
        sudokuMenuBar.add(menuActions);
        
        //Difficulty Selection
        JMenu menuDifficulty = new JMenu("Difficulty");
        menuActions.add(menuDifficulty);
		
        menuDifficultyEasiest = new JCheckBoxMenuItem("Easiest");
        menuDifficultyEasiest.setSelected(true);  //default to easiest
        _difficultyLevel = 0;                     //default to easiest
        menuDifficultyEasiest.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JCheckBoxMenuItem item = (JCheckBoxMenuItem)e.getSource();
                if (item.getState())
                {
                    _difficultyLevel = 0;
                    menuDifficultyEasiest.setSelected(true);
                    menuDifficultyEasy.setSelected(false);
                    menuDifficultyMedium.setSelected(false);
                    menuDifficultyHard.setSelected(false);
                }
                else
                {
                    menuDifficultyEasiest.setSelected(false);
                }   
            }
        });
        menuDifficulty.add(menuDifficultyEasiest);

        menuDifficultyEasy = new JCheckBoxMenuItem("Easy");
        menuDifficultyEasy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JCheckBoxMenuItem item = (JCheckBoxMenuItem)e.getSource();
                if (item.getState())
                {
                    _difficultyLevel = 1;
                    menuDifficultyEasiest.setSelected(false);
                    menuDifficultyEasy.setSelected(true);
                    menuDifficultyMedium.setSelected(false);
                    menuDifficultyHard.setSelected(false);
                }
                else
                {
                    menuDifficultyEasy.setSelected(false);
                }
            }
        });
        menuDifficulty.add(menuDifficultyEasy);
        
        menuDifficultyMedium = new JCheckBoxMenuItem("Medium");
        menuDifficultyMedium.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JCheckBoxMenuItem item = (JCheckBoxMenuItem)e.getSource();
                if (item.getState())
                {
                    _difficultyLevel = 2;
                    menuDifficultyEasiest.setSelected(false);
                    menuDifficultyEasy.setSelected(false);
                    menuDifficultyMedium.setSelected(true);
                    menuDifficultyHard.setSelected(false);
                }
                else
                {
                    menuDifficultyMedium.setSelected(false);
                }
            }
        });
        menuDifficulty.add(menuDifficultyMedium);
        
        menuDifficultyHard = new JCheckBoxMenuItem("Difficult");
        menuDifficultyHard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JCheckBoxMenuItem item = (JCheckBoxMenuItem)e.getSource();
                if (item.getState())
                {
                    _difficultyLevel = 3;
                    menuDifficultyEasiest.setSelected(false);
                    menuDifficultyEasy.setSelected(false);
                    menuDifficultyMedium.setSelected(false);
                    menuDifficultyHard.setSelected(true);
                }
                else
                {
                    menuDifficultyHard.setSelected(false);
                }
            }
        });
        menuDifficulty.add(menuDifficultyHard);

        menuActions.add(menuDifficulty);
        
        //New Game Selection
        JMenuItem menuNewGame = new JMenuItem("New Game");
        menuNewGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                CreateNewGame();
            }
        });
        menuActions.add(menuNewGame);
        
        //if user makes a lot of mistakes, allow to reset
        //to start condition
        JMenuItem menuResetGrid = new JMenuItem("Reset Grid");
        menuResetGrid.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                ResetGameGrid();
            }
        });
        menuActions.add(menuResetGrid);
        
        
        //if user is fed up and wants to see the solution
        //allow the user to see the solution on one click:
        JMenuItem menuSolveGrid = new JMenuItem("Solve Grid");
        menuSolveGrid.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                SolveGameGrid();
            }
        });
        menuActions.add(menuSolveGrid);
        
        //Save and Retore options:
        JMenu menuSaveGameOptions = new JMenu("File Options");
        
        JMenuItem menuSaveGame = new JMenuItem("Save Game");
        menuSaveGame.addActionListener(new SaveGameAction());
        menuSaveGameOptions.add(menuSaveGame);
        
        JMenuItem menuRestoreGame = new JMenuItem("Restore Game");
        menuRestoreGame.addActionListener(new RestoreGameAction());
        menuSaveGameOptions.add(menuRestoreGame);
        
        sudokuMenuBar.add(menuSaveGameOptions);
        
        
        
        //game board for sudoku grid play
        _innerBoard = new JPanel();
        _innerBoard.setBounds(10, 40, 303, 355);
        _innerBoard.setBorder(new javax.swing.border.LineBorder(Color.BLACK, 1));
        _innerBoard.setLayout(new GridLayout(3,3,3,3));
        _gamePanel.add(_innerBoard);
        
        //create the board:
        panel1 = new JPanel();
        panel1.setBorder(new javax.swing.border.LineBorder(Color.BLACK, 1));
        panel2 = new JPanel();
        panel2.setBorder(new javax.swing.border.LineBorder(Color.BLACK, 1));
        panel3 = new JPanel();
        panel3.setBorder(new javax.swing.border.LineBorder(Color.BLACK, 1));
        panel4 = new JPanel();
        panel4.setBorder(new javax.swing.border.LineBorder(Color.BLACK, 1));
        panel5 = new JPanel();
        panel5.setBorder(new javax.swing.border.LineBorder(Color.BLACK, 1));
        panel6 = new JPanel();
        panel6.setBorder(new javax.swing.border.LineBorder(Color.BLACK, 1));
        panel7 = new JPanel();
        panel7.setBorder(new javax.swing.border.LineBorder(Color.BLACK, 1));
        panel8 = new JPanel();
        panel8.setBorder(new javax.swing.border.LineBorder(Color.BLACK, 1));
        panel9 = new JPanel();
        panel9.setBorder(new javax.swing.border.LineBorder(Color.BLACK, 1));
        
        panel1.setLayout(new GridLayout(3,3,3,3));
        panel2.setLayout(new GridLayout(3,3,3,3));
        panel3.setLayout(new GridLayout(3,3,3,3));
        panel4.setLayout(new GridLayout(3,3,3,3));
        panel5.setLayout(new GridLayout(3,3,3,3));
        panel6.setLayout(new GridLayout(3,3,3,3));
        panel7.setLayout(new GridLayout(3,3,3,3));
        panel8.setLayout(new GridLayout(3,3,3,3));
        panel9.setLayout(new GridLayout(3,3,3,3));
   
        //00 01 02
        //10 11 12
        //20 21 22
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                final SudokuGridCell sgc = new SudokuGridCell(1);
                sgc.setName(String.format("%s_%s"
                                , i, j));
                sgc.addKeyListener(new KeyAdapter(){
                    public void keyTyped(KeyEvent e){
                        char c = e.getKeyChar();
                        if ( ((c < '1') || (c > '9')) || sgc.getIsLocked())
                        {
                            e.consume(); //ignore
                        }
                        else
                        {
                            //reset the text to just this value
                            String t = String.format("%s", c);
                            String n = sgc.getName();
                            int row = Integer.parseInt(n.substring(0,1));
                            int col = Integer.parseInt(n.substring(2,3));
                            int num = Integer.parseInt(t);
                            sgc.setText(t);
                            boolean isValid = 
                                    _gameGrid.CheckCellValue(row, col, num);
                            if (isValid)
                            {
                                //actually set it
                                _gameGrid.SetCellValue(row, col, num);
                                
                                
                            }
                            else
                            {
                                //make sure the game grid value isn't set
                                //if they change away from a good value...
                                _gameGrid.SetCellValue(row, col, 0);
                            }
                            
                            //if cheat hints are on, color it red if 
                            //the cell is actually not correct even
                            //if it has a value:
                            if (_allowHintColoring)
                            {
                                if (!ValidateCellAgainstSolution(sgc))
                                {
                                    sgc.setForeground(badRedColor);
                                }
                                else
                                {
                                    sgc.setForeground(goodGreenColor);
                                }
                            }
                                
                            CheckIsSolved();
                            e.consume();
                        }
                    }
                });
                panel1.add(sgc);
            }
        }
        
        //03 04 05
        //13 14 15
        //23 24 25
        for (int i = 0; i < 3; i++)
        {
            for (int j = 3; j < 6; j++)
            {
                final SudokuGridCell sgc = new SudokuGridCell(1);
                sgc.setName(String.format("%s_%s"
                                , i, j));
                sgc.addKeyListener(new KeyAdapter(){
                    public void keyTyped(KeyEvent e){
                        char c = e.getKeyChar();
                        if ( ((c < '1') || (c > '9')) || sgc.getIsLocked())
                        {
                            e.consume(); //ignore
                        }
                        else
                        {
                            //reset the text to just this value
                            String t = String.format("%s", c);
                            String n = sgc.getName();
                            int row = Integer.parseInt(n.substring(0,1));
                            int col = Integer.parseInt(n.substring(2,3));
                            int num = Integer.parseInt(t);
                            sgc.setText(t);
                            boolean isValid = 
                                    _gameGrid.CheckCellValue(row, col, num);
                            if (isValid)
                            {
                                //actually set it
                                _gameGrid.SetCellValue(row, col, num);
                                
                                
                            }
                            else
                            {
                                //make sure the game grid value isn't set
                                //if they change away from a good value...
                                _gameGrid.SetCellValue(row, col, 0);
                            }
                            
                            //if cheat hints are on, color it red if 
                            //the cell is actually not correct even
                            //if it has a value:
                            if (_allowHintColoring)
                            {
                                if (!ValidateCellAgainstSolution(sgc))
                                {
                                    sgc.setForeground(badRedColor);
                                }
                                else
                                {
                                    sgc.setForeground(goodGreenColor);
                                }
                            }
                            CheckIsSolved();
                            e.consume();
                        }
                    }
                });
                //sgc.addMouseListener(new GridCellMouseListener());
                panel2.add(sgc);
            }
        }
        
        //06 07 08
        //16 17 18
        //26 27 28
        for (int i = 0; i < 3; i++)
        {
            for (int j = 6; j < 9; j++)
            {
                final SudokuGridCell sgc = new SudokuGridCell(1);
                sgc.setName(String.format("%s_%s"
                                , i, j));
                sgc.addKeyListener(new KeyAdapter(){
                    public void keyTyped(KeyEvent e){
                        char c = e.getKeyChar();
                        if ( ((c < '1') || (c > '9')) || sgc.getIsLocked())
                        {
                            e.consume(); //ignore
                        }
                        else
                        {
                            //reset the text to just this value
                            String t = String.format("%s", c);
                            String n = sgc.getName();
                            int row = Integer.parseInt(n.substring(0,1));
                            int col = Integer.parseInt(n.substring(2,3));
                            int num = Integer.parseInt(t);
                            sgc.setText(t);
                            boolean isValid = 
                                    _gameGrid.CheckCellValue(row, col, num);
                            if (isValid)
                            {
                                //actually set it
                                _gameGrid.SetCellValue(row, col, num);
                                
                                
                            }
                            else
                            {
                                //make sure the game grid value isn't set
                                //if they change away from a good value...
                                _gameGrid.SetCellValue(row, col, 0);
                            }
                            
                            //if cheat hints are on, color it red if 
                            //the cell is actually not correct even
                            //if it has a value:
                            if (_allowHintColoring)
                            {
                                if (!ValidateCellAgainstSolution(sgc))
                                {
                                    sgc.setForeground(badRedColor);
                                }
                                else
                                {
                                    sgc.setForeground(goodGreenColor);
                                }
                            }
                            CheckIsSolved();
                            e.consume();
                        }
                    }
                });
                panel3.add(sgc);
            }
        }
        
        //panel 4
        //30 31 32
        //40 41 42
        //50 51 52
        for (int i = 3; i < 6; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                final SudokuGridCell sgc = new SudokuGridCell(1);
                sgc.setName(String.format("%s_%s"
                                , i, j));
                sgc.addKeyListener(new KeyAdapter(){
                    public void keyTyped(KeyEvent e){
                        char c = e.getKeyChar();
                        if ( ((c < '1') || (c > '9')) || sgc.getIsLocked())
                        {
                            e.consume(); //ignore
                        }
                        else
                        {
                            //reset the text to just this value
                            String t = String.format("%s", c);
                            String n = sgc.getName();
                            int row = Integer.parseInt(n.substring(0,1));
                            int col = Integer.parseInt(n.substring(2,3));
                            int num = Integer.parseInt(t);
                            sgc.setText(t);
                            boolean isValid = 
                                    _gameGrid.CheckCellValue(row, col, num);
                            if (isValid)
                            {
                                //actually set it
                                _gameGrid.SetCellValue(row, col, num);
                                
                                
                            }
                            else
                            {
                                //make sure the game grid value isn't set
                                //if they change away from a good value...
                                _gameGrid.SetCellValue(row, col, 0);
                            }
                            
                            //if cheat hints are on, color it red if 
                            //the cell is actually not correct even
                            //if it has a value:
                            if (_allowHintColoring)
                            {
                                if (!ValidateCellAgainstSolution(sgc))
                                {
                                    sgc.setForeground(badRedColor);
                                }
                                else
                                {
                                    sgc.setForeground(goodGreenColor);
                                }
                            }
                            CheckIsSolved();    
                            e.consume();
                        }
                    }
                });
                //sgc.addMouseListener(new GridCellMouseListener());
                panel4.add(sgc);
            }
        }
        
        
        //panel 5
        //33 34 35
        //43 44 45
        //53 54 55
        for (int i = 3; i < 6; i++)
        {
            for (int j = 3; j < 6; j++)
            {
                final SudokuGridCell sgc = new SudokuGridCell(1);
                sgc.setName(String.format("%s_%s"
                                , i, j));
                sgc.addKeyListener(new KeyAdapter(){
                    public void keyTyped(KeyEvent e){
                        char c = e.getKeyChar();
                        if ( ((c < '1') || (c > '9')) || sgc.getIsLocked())
                        {
                            e.consume(); //ignore
                        }
                        else
                        {
                            //reset the text to just this value
                            String t = String.format("%s", c);
                            String n = sgc.getName();
                            int row = Integer.parseInt(n.substring(0,1));
                            int col = Integer.parseInt(n.substring(2,3));
                            int num = Integer.parseInt(t);
                            sgc.setText(t);
                            boolean isValid = 
                                    _gameGrid.CheckCellValue(row, col, num);
                            if (isValid)
                            {
                                //actually set it
                                _gameGrid.SetCellValue(row, col, num);
                                
                                
                            }
                            else
                            {
                                //make sure the game grid value isn't set
                                //if they change away from a good value...
                                _gameGrid.SetCellValue(row, col, 0);
                            }
                            
                            //if cheat hints are on, color it red if 
                            //the cell is actually not correct even
                            //if it has a value:
                            if (_allowHintColoring)
                            {
                                if (!ValidateCellAgainstSolution(sgc))
                                {
                                    sgc.setForeground(badRedColor);
                                }
                                else
                                {
                                    sgc.setForeground(goodGreenColor);
                                }
                            }
                            CheckIsSolved();    
                            e.consume();
                        }
                    }
                });
                panel5.add(sgc);
            }
        }
        
        //panel 6
        //36 37 38
        //46 47 48
        //56 57 58
        for (int i = 3; i < 6; i++)
        {
            for (int j = 6; j < 9; j++)
            {
                final SudokuGridCell sgc = new SudokuGridCell(1);
                sgc.setName(String.format("%s_%s"
                                , i, j));
                sgc.addKeyListener(new KeyAdapter(){
                    public void keyTyped(KeyEvent e){
                        char c = e.getKeyChar();
                        if ( ((c < '1') || (c > '9')) || sgc.getIsLocked())
                        {
                            e.consume(); //ignore
                        }
                        else
                        {
                            //reset the text to just this value
                            String t = String.format("%s", c);
                            String n = sgc.getName();
                            int row = Integer.parseInt(n.substring(0,1));
                            int col = Integer.parseInt(n.substring(2,3));
                            int num = Integer.parseInt(t);
                            sgc.setText(t);
                            boolean isValid = 
                                    _gameGrid.CheckCellValue(row, col, num);
                            if (isValid)
                            {
                                //actually set it
                                _gameGrid.SetCellValue(row, col, num);
                                
                                
                            }
                            else
                            {
                                //make sure the game grid value isn't set
                                //if they change away from a good value...
                                _gameGrid.SetCellValue(row, col, 0);
                            }
                            
                            //if cheat hints are on, color it red if 
                            //the cell is actually not correct even
                            //if it has a value:
                            if (_allowHintColoring)
                            {
                                if (!ValidateCellAgainstSolution(sgc))
                                {
                                    sgc.setForeground(badRedColor);
                                }
                                else
                                {
                                    sgc.setForeground(goodGreenColor);
                                }
                            }
                            CheckIsSolved();    
                            e.consume();
                        }
                    }
                });
                panel6.add(sgc);
            }
        }
        
        //panel 7
        //60 61 62
        //70 71 72
        //80 81 82
        for (int i = 6; i < 9; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                final SudokuGridCell sgc = new SudokuGridCell(1);
                sgc.setName(String.format("%s_%s"
                                , i, j));
                sgc.addKeyListener(new KeyAdapter(){
                    public void keyTyped(KeyEvent e){
                        char c = e.getKeyChar();
                        if ( ((c < '1') || (c > '9')) || sgc.getIsLocked())
                        {
                            e.consume(); //ignore
                        }
                        else
                        {
                            //reset the text to just this value
                            String t = String.format("%s", c);
                            String n = sgc.getName();
                            int row = Integer.parseInt(n.substring(0,1));
                            int col = Integer.parseInt(n.substring(2,3));
                            int num = Integer.parseInt(t);
                            sgc.setText(t);
                            boolean isValid = 
                                    _gameGrid.CheckCellValue(row, col, num);
                            if (isValid)
                            {
                                //actually set it
                                _gameGrid.SetCellValue(row, col, num);
                                
                                
                            }
                            else
                            {
                                //make sure the game grid value isn't set
                                //if they change away from a good value...
                                _gameGrid.SetCellValue(row, col, 0);
                            }
                            
                            //if cheat hints are on, color it red if 
                            //the cell is actually not correct even
                            //if it has a value:
                            if (_allowHintColoring)
                            {
                                if (!ValidateCellAgainstSolution(sgc))
                                {
                                    sgc.setForeground(badRedColor);
                                }
                                else
                                {
                                    sgc.setForeground(goodGreenColor);
                                }
                            }
                            CheckIsSolved();    
                            e.consume();
                        }
                    }
                });
                panel7.add(sgc);
            }
        }
        
        //panel 8
        //63 64 65
        //73 74 75
        //83 84 85
        for (int i = 6; i < 9; i++)
        {
            for (int j =3; j < 6; j++)
            {
                final SudokuGridCell sgc = new SudokuGridCell(1);
                sgc.setName(String.format("%s_%s"
                                , i, j));
                sgc.addKeyListener(new KeyAdapter(){
                    public void keyTyped(KeyEvent e){
                        char c = e.getKeyChar();
                        if ( ((c < '1') || (c > '9')) || sgc.getIsLocked())
                        {
                            e.consume(); //ignore
                        }
                        else
                        {
                            //reset the text to just this value
                            String t = String.format("%s", c);
                            String n = sgc.getName();
                            int row = Integer.parseInt(n.substring(0,1));
                            int col = Integer.parseInt(n.substring(2,3));
                            int num = Integer.parseInt(t);
                            sgc.setText(t);
                            boolean isValid = 
                                    _gameGrid.CheckCellValue(row, col, num);
                            if (isValid)
                            {
                                //actually set it
                                _gameGrid.SetCellValue(row, col, num);
                                
                                
                            }
                            else
                            {
                                //make sure the game grid value isn't set
                                //if they change away from a good value...
                                _gameGrid.SetCellValue(row, col, 0);
                            }
                            
                            //if cheat hints are on, color it red if 
                            //the cell is actually not correct even
                            //if it has a value:
                            if (_allowHintColoring)
                            {
                                if (!ValidateCellAgainstSolution(sgc))
                                {
                                    sgc.setForeground(badRedColor);
                                }
                                else
                                {
                                    sgc.setForeground(goodGreenColor);
                                }
                            }
                            CheckIsSolved();    
                            e.consume();
                        }
                    }
                });
                panel8.add(sgc);
            }
        }
        
        //panel 9
        //66 67 68
        //76 77 78
        //86 87 88
        for (int i = 6; i < 9; i++)
        {
            for (int j = 6; j < 9; j++)
            {
                final SudokuGridCell sgc = new SudokuGridCell(1);
                sgc.setName(String.format("%s_%s"
                                , i, j));
                sgc.addKeyListener(new KeyAdapter(){
                    public void keyTyped(KeyEvent e){
                        char c = e.getKeyChar();
                        if ( ((c < '1') || (c > '9')) || sgc.getIsLocked())
                        {
                            e.consume(); //ignore
                        }
                        else
                        {
                            //reset the text to just this value
                            String t = String.format("%s", c);
                            String n = sgc.getName();
                            int row = Integer.parseInt(n.substring(0,1));
                            int col = Integer.parseInt(n.substring(2,3));
                            int num = Integer.parseInt(t);
                            sgc.setText(t);
                            boolean isValid = 
                                    _gameGrid.CheckCellValue(row, col, num);
                            if (isValid)
                            {
                                //actually set it
                                _gameGrid.SetCellValue(row, col, num);
                                
                                
                            }
                            else
                            {
                                //make sure the game grid value isn't set
                                //if they change away from a good value...
                                _gameGrid.SetCellValue(row, col, 0);
                            }
                            
                            //if cheat hints are on, color it red if 
                            //the cell is actually not correct even
                            //if it has a value:
                            if (_allowHintColoring)
                            {
                                if (!ValidateCellAgainstSolution(sgc))
                                {
                                    sgc.setForeground(badRedColor);
                                }
                                else
                                {
                                    sgc.setForeground(goodGreenColor);
                                }
                            }
                            CheckIsSolved();    
                            e.consume();
                        }
                    }
                });
                panel9.add(sgc);
            }
        }
        
        _innerBoard.add(panel1);
        _innerBoard.add(panel2);
        _innerBoard.add(panel3);
        _innerBoard.add(panel4);
        _innerBoard.add(panel5);
        _innerBoard.add(panel6);
        _innerBoard.add(panel7);
        _innerBoard.add(panel8);
        _innerBoard.add(panel9);
        
        //
        
        _gamePanel.add(_innerBoard);
        
        this.add(_gamePanel);
        this.title = "Sudoku";
        
        //pack and show:
        pack();
        setVisible(true);
    }
    
    /**
     * Validate a cell value using the cell name to get x/y and validation 
     * methods against solution (hints red if the cell is not a valid value).
     * @param sgc The cell to validate
     * @return true if value is valid, else false
     */
    private boolean ValidateCellAgainstSolution(SudokuGridCell sgc)
    {
        SudokuGridValueCell[][] sol = _gameGrid.getSolution();
        String s = sgc.getName();
        int row = Integer.parseInt(s.substring(0, 1));
        int col = Integer.parseInt(s.substring(2, 3));
        SudokuGridValueCell solCell = sol[row][col];
        return solCell.getValue() == Integer.parseInt(sgc.getText());
    }
    
    /**
     * Check is solved.
     */
    private void CheckIsSolved()
    {
        boolean solved = _gameGrid.IsSolved();
        if (solved)
        {
            UnlockAllCells(false);
            
            JOptionPane.showMessageDialog(null
                    , "Congratulations! You solved the puzzle"
                    , "Solved!"
                    , JOptionPane.INFORMATION_MESSAGE);
            
        }
    }
    
    /**
     * Lock or unlock all cells on the grid
     * @param unlock true to unlock all cells, false to lock all cells
     */
    private void UnlockAllCells(boolean unlock)
    {
        Component[] grids = _innerBoard.getComponents();
        for(Component g : grids)
        {
            Component[] boxes = ((JPanel)g).getComponents();
            for (Component b : boxes)
            {
                //lock the board:
                SudokuGridCell sgc = (SudokuGridCell)b;
                sgc.setEnabled(unlock);
            }
        }
    }
    
    /**
     * Create a new game.
     */
    private void CreateNewGame()
    {
        UnlockAllCells(true);
        
        //just like in the regular game play, we need to create our setup
        if (_difficultyLevel == 0)
        {
            //on the easiest level, leave cheat colors on:
            _allowHintColoring = true;
        }
        else
        {
            //turn them off otherwise
            _allowHintColoring = false;
        }
        _gameGrid = new SudokuGrid(_difficultyLevel);
        
        //use the start condition to populate the cells with data
        SudokuGridValueCell[][] startState = _gameGrid.getStartCondition();
        
        Component[] grids = _innerBoard.getComponents();
        
        for(Component g : grids)
        {
            Component[] boxes = ((JPanel)g).getComponents();
            for (Component b : boxes)
            {
                SudokuGridCell sgc = (SudokuGridCell)b;
                sgc.setText("");
                sgc.setBackground(Color.WHITE);
                sgc.setIsLocked(false);
                
                //get the row/col from the cell name
                String[] cellPos = sgc.getName().split("\\_");
                int i = Integer.parseInt(cellPos[0]);
                int j = Integer.parseInt(cellPos[1]);
                SudokuGridValueCell sgvc = startState[i][j];
                if (sgvc.getValue() > 0)
                {
                    sgc.setText(String.format("%d", sgvc.getValue()));
                    sgc.setForeground(Color.BLACK);
                    sgc.setBackground(Color.LIGHT_GRAY);
                    sgc.setIsLocked(true);
                }
            }
        }
    }
    
    /**
     * Reset the grid to start condition
     */
    private void ResetGameGrid()
    {
        UnlockAllCells(true);
        Component[] grids = _innerBoard.getComponents();
                
        //now here comes the trick.
        //essentially have to put the values in every single
        //text from the _grid.start condition and set the gameGrid back
        //to start condition
        SudokuGridValueCell[][] originalGridStartCondition = 
                _gameGrid.getStartCondition();
        for(Component g : grids)
        {
            Component[] boxes = ((JPanel)g).getComponents();
            for (Component b : boxes)
            {
                //these are the individual cells on the board:
                String s = b.getName();
                int row = Integer.parseInt(s.substring(0, 1));
                int col = Integer.parseInt(s.substring(2, 3));

                int startGridVal =
                    originalGridStartCondition[row][col].getValue();

                //clear the board:
                SudokuGridCell sgc = (SudokuGridCell)b;
                sgc.setText("");
                sgc.setBackground(Color.WHITE);
                sgc.setIsLocked(false);

                if (startGridVal > 0)
                {
                    //if was filled, populate it
                    sgc.setText(String.format("%d", startGridVal));
                    sgc.setForeground(Color.BLACK);
                    sgc.setBackground(Color.LIGHT_GRAY);
                    sgc.setIsLocked(true);
                } 
            }
        }
        
        //now set the current state back to start state:
        _gameGrid.InstantResetGrid();
    }
    
    /**
     * Solve the Game Grid.
     */
    private void SolveGameGrid()
    {
        int continueSolve = JOptionPane.showConfirmDialog(null
                , "Are you sure you want to give up?"
                , "Throw in the towel?"
                , JOptionPane.OK_CANCEL_OPTION);
        System.out.println(continueSolve);
        if (continueSolve == 0)
        {
            _gameGrid.InstantSolveGrid();
        }
        else
        {
            return;
        }
        
        SudokuGridValueCell[][] sol = _gameGrid.getSolution();
        
        Component[] grids = _innerBoard.getComponents();
        for(Component g : grids)
        {
            Component[] boxes = ((JPanel)g).getComponents();
            for (Component b : boxes)
            {
                //these are the individual cells on the board:
                String s = b.getName();
                int row = Integer.parseInt(s.substring(0, 1));
                int col = Integer.parseInt(s.substring(2, 3));

                int solValue =
                    sol[row][col].getValue();

                //solve the board:
                SudokuGridCell sgc = (SudokuGridCell)b;
                sgc.setText(String.format("%d", solValue));
                sgc.setBackground(Color.WHITE);
                sgc.setIsLocked(false);
                sgc.setEnabled(false);
            }
        }
    }
    
    /**
     * Save the current grid state for restore later.
     */
    class SaveGameAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            //save the current game grid to binary file
            FileOutputStream fos = null;
            ObjectOutputStream oos = null;
            try
            {
                fos = new FileOutputStream(_saveRestorePath);
                oos = new ObjectOutputStream(fos);
                
                //save as is. no need to do anything else.
                oos.writeObject(_gameGrid);
                JOptionPane.showMessageDialog(null
                        , "Game Successfully Saved"
                        , "SUCCESS"
                        , JOptionPane.INFORMATION_MESSAGE);
            }
            catch (Exception ex)
            {
                JOptionPane.showMessageDialog(null
                        , "Could not save game"
                        , "ERROR"
                        , JOptionPane.ERROR_MESSAGE);
            }
            finally
            {
                try
                {
                    if (fos != null) fos.close();
                    if (oos != null) oos.close();
                }
                catch (Exception innerEx)
                {
                    JOptionPane.showMessageDialog(null
                        , "Error Closing files"
                        , "ERROR"
                        , JOptionPane.ERROR_MESSAGE);
                }
                finally
                {
                    fos = null;
                    oos = null;
                }
            }
        }
    }
    
    /**
     * Restore a previously saved game:
     */
    class RestoreGameAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            UnlockAllCells(true);
            FileInputStream fis = null;
            ObjectInputStream ois = null;
            try
            {
                fis = new FileInputStream(_saveRestorePath);
                ois = new ObjectInputStream(fis);
                
                _gameGrid = (SudokuGrid)ois.readObject();
                
                //get the grid panels from the board:
                Component[] grids = _innerBoard.getComponents();
                
                //now here comes the trick.
                //essentially have to put the values in every single
                //text from the _grid.Gamegrid
                SudokuGridValueCell[][] restoredGridCurrentCondition = 
                        _gameGrid.getGameGrid();
                SudokuGridValueCell[][] restoredGridStartCondition = 
                        _gameGrid.getStartCondition();
                for(Component g : grids)
                {
                    Component[] boxes = ((JPanel)g).getComponents();
                    for (Component b : boxes)
                    {
                        //these are the individual cells on the board:
                        String s = b.getName();
                        int row = Integer.parseInt(s.substring(0, 1));
                        int col = Integer.parseInt(s.substring(2, 3));
                        
                        int gameGridVal = 
                            restoredGridCurrentCondition[row][col].getValue();
                        int startGridVal =
                            restoredGridStartCondition[row][col].getValue();
                        
                        //clear the board:
                        SudokuGridCell sgc = (SudokuGridCell)b;
                        sgc.setText("");
                        sgc.setBackground(Color.WHITE);
                        sgc.setIsLocked(false);
                        sgc.setEnabled(true);
                        
                        if (gameGridVal > 0)
                        {
                            //if was filled, populate it
                            sgc.setText(String.format("%d", gameGridVal));
                            if (startGridVal > 0)
                            {
                                //if was original start value
                                //color it
                                sgc.setForeground(Color.BLACK);
                                sgc.setBackground(Color.LIGHT_GRAY);
                                sgc.setIsLocked(true);
                            }
                        }
                        //NOTE: Cell coloring for hint/cheat is lost in restor
                        //      This is a known bug and not a concern at this
                        //      Time.
                    }
                }
            }
            catch (Exception ex)
            {
                JOptionPane.showMessageDialog(null
                        , "Could not restore game"
                        , "ERROR"
                        , JOptionPane.ERROR_MESSAGE);
            }
            finally
            {
            
            }
            JOptionPane.showMessageDialog(null
                        , "Game Successfully Restored!"
                        , "SUCCESS"
                        , JOptionPane.INFORMATION_MESSAGE);
        }
    
    }
}
