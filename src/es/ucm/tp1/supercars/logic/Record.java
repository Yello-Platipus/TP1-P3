package es.ucm.tp1.supercars.logic;

import es.ucm.tp1.supercars.control.Level;
import es.ucm.tp1.supercars.control.exceptions.InputOutputRecordException;

import java.io.*;
import java.util.Scanner;

public class Record {
    private Level level;
    private long recordTime;
    private Scanner scanner;
    private static final String RECORD_FILENAME = "record.txt";

    public Record(Level level) throws InputOutputRecordException{
        this.level = level;
        searchRecord();
    }

    public void searchRecord() throws InputOutputRecordException{
        File file = new File(RECORD_FILENAME);
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException fnfe){
            throw new InputOutputRecordException();
        }
        while(scanner.findInLine(level.toString() + ":") == null && scanner.hasNextLine()){
            scanner.nextLine();
        }
        if(scanner.hasNextLong())
            recordTime = scanner.nextLong();
        else
            recordTime = Long.MAX_VALUE;
    }

    public void saveRecord() throws InputOutputRecordException{
        File file = new File(RECORD_FILENAME);
        StringBuilder sb = new StringBuilder();
        try{
            scanner = new Scanner(file);
            BufferedWriter save = new BufferedWriter(new FileWriter(RECORD_FILENAME));
        } catch (IOException ioe){
            throw new InputOutputRecordException();
        }
        while(scanner.findInLine(level.toString() + ":") == null && scanner.hasNextLine()){
            sb.append(scanner.nextLine());
            System.out.println(sb.toString()); //TODO QUITARLO, ES SOLO PARA PROBAR SI FUNCIONA
        }
        if(scanner.hasNextLong())
            recordTime = scanner.nextLong();
        else
            recordTime = Long.MAX_VALUE;
    }

    public long getRecord(){
        return recordTime;
    }
}
