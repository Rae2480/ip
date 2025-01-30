import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskList {
    private static final String FILE_PATH = "./ip/data/viktor.txt";

    public void save(ArrayList<Task> tasks) throws IOException {
        File f = new File(FILE_PATH);
        f.getParentFile().mkdirs();
        f.createNewFile();
        try {
            FileWriter fw = new FileWriter(f);
            for (Task t : tasks) {
                fw.write(t.toSave() + "\n");
            }
            fw.close();
        } catch (IOException e) {
            throw new IOException("Error saving file");
        }
    }

    public ArrayList<Task> load() throws IOException {
        File f = new File(FILE_PATH);
        ArrayList<Task> tasks = new ArrayList<>();
        try {
            Scanner s = new Scanner(f);
            while (s.hasNext()) {
                String line = s.nextLine();
                String[] parts = line.split(" \\| ");
                if (parts[0].equals("T")) {
                    tasks.add(new Todo(parts[2]));
                    if (parts[1].equals("X")) {
                        tasks.get(tasks.size() - 1).beDone();
                    }
                } else if (parts[0].equals("D")) {
                    tasks.add(new Deadline(parts[2], parts[3]));
                    if (parts[1].equals("X")) {
                        tasks.get(tasks.size() - 1).beDone();
                    }
                } else if (parts[0].equals("E")) {
                    tasks.add(new Event(parts[2], parts[3], parts[4]));
                    if (parts[1].equals("X")) {
                        tasks.get(tasks.size() - 1).beDone();
                    }
                }
            }
            s.close();
            return tasks;

        } catch (FileNotFoundException e) {
            throw new IOException("File not found");
        } 
    }
}
