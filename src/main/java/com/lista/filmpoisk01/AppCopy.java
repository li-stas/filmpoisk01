package com.lista.filmpoisk01;
/*

public class AppCopy {
  try {
            // создаем 2 потока для сериализации объекта и сохранения его в байты (файл)
            File file = new File("input.bin");

            FileOutputStream fos = new FileOutputStream( file);
            ObjectOutputStream ous = new ObjectOutputStream(fos);
            // задачу  объекта в поток байтов
            ous.writeObject(zsmk49.getStudents());
            ous.close();

            // создние каталога
            File folder = new File("copy");
            folder.mkdir();


            // копироварние
            //File source = new File("input.bin");
            //File dest = new File("copy\\input.bin");
            //Files.copy(source.toPath(), dest.toPath());

            InputStream is = null;
            OutputStream os = null;
            try {
                is = new FileInputStream("input.bin");
                os = new FileOutputStream("copy\\input.bin");
                byte[] buffer = new byte[1024];
                int length;
                while ((length = is.read(buffer)) > 0) {
                    os.write(buffer, 0, length);
                }
            } finally {
                is.close();
                os.close();
            }



            file = new File("copy\\input.bin");
            FileInputStream fis =  new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            //эксгумация потока
            Student[] students1 = (Student[]) ois.readObject();
            System.out.println(Arrays.toString(students1));
            ois.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
*/
