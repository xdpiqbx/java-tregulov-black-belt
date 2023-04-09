## Use `try with resources`

```java
try(FileWriter writer = new FileWriter("src/main/resources/test_001.txt");
    FileReader fileReader = new FileReader("src/main/resources/test_001.txt");) {
// ...
} catch (IOException e) {
    throw new RuntimeException(e);
}
```

---

## [FileWriter](./Demo_001_FileWriter.java)

- FileWriter writer = new FileWriter(`"test_001.txt"`) - it will create file in project folder
- FileWriter writer = new FileWriter(`"src/main/resources/test_001.txt"`) - set filepath
- FileWriter writer = new FileWriter("src/main/resources/test_001.txt", `true`) - append to existing

- `Writes` text to character files using a default buffer size.

---

## [FileReader](./Demo_002_FileRedaer.java)
- `Reads` text from character files using a default buffer size

---

## [BufferedReader & BufferedWriter](./Demo_003_Buffered_reader_writer.java)
- `Reads` text from a character-input stream, buffering characters so as to provide for the efficient reading of characters, arrays, and lines
- `Writes` text to a character-output stream, buffering characters so as to provide for the efficient writing of single characters, arrays, and strings

---

## [FileOutputStream & FileInputStream](./Demo_004_File_IO_Stream.java)
- A `FileInputStream` obtains input bytes from a file in a file system.
- A `file output stream` is an output stream for writing data to a File or to a FileDescriptor.

---

## [DataOutputStream & DataInputStream](./Demo_005_Data_IO_Stream.java)
- A data `output` stream lets an application write primitive Java data types to an output stream in a portable way.
- A data `input` stream lets an application read primitive Java data types from an underlying input stream in a machine-independent way. 

---

## Serialization
- `implements Serializable` (empty interface)
- `transient` double salary; (is not serializable)
- `serialVersionUID`
- `InvalidClassException` (when `serialVersionUID` in different in )

## [Serialization list of Strings to file](./Demo_006_Serialization_001.java)

## [Deserialization list of Strings from file](./Demo_006_Serialization_002.java)

## [Serialization list of Objects to file](./Demo_006_Serialization_001_1.java)

## [Deserialization list of Objects from file](./Demo_006_Serialization_002_1.java)
