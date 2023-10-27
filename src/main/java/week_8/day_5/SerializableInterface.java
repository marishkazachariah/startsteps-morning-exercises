package week_8.day_5;

import java.io.IOException;

interface SerializableInterface {
    void serialize(String filename);
    void deserialize(String filename) throws IOException, ClassNotFoundException;
}