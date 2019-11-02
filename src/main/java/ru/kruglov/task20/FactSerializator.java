package ru.kruglov.task20;

import java.io.*;
import java.util.ArrayList;

public class FactSerializator {
    private String pathToDatFile = "facts.dat";

    public void saveArrayOfFactsToFile(ArrayList<Fact> arrayOfFacts) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(pathToDatFile)))
        {
           // ArrayList<Fact> arrayOfFacts = new ArrayList<>();
            oos.writeObject(arrayOfFacts);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public ArrayList getArrayOfFactsFromFile() {
        ArrayList arrayOfFacts = null;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(pathToDatFile))) {
            arrayOfFacts = (ArrayList) ois.readObject();
        } catch (FileNotFoundException  e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return arrayOfFacts;
    }
}
