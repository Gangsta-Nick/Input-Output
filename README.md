## Потоки ввода-вывода. Работа с файлами. Сериализация.

### Input-Output

В данной задаче Вы потренируетесь работать с файлами и каталогами в файловой системе, используя язык Java и класс `File`, и смоделируете процесс установки игры на жесткий диск комьютера.


Установку программы необходимо производить из Java кода с использованием класса `File`. Процесс будет состоять из следующих этапов:
1. На диске создавется папка `Games`
2. В папке `Games` создается несколько директорий: `src`, `res`, `savegames`, `temp`. 
3. В каталоге `src` две директории: `main`, `test`. 
4. В подкаталоге `main` создается два файла: `Main.java`, `Utils.java`. 
5. В каталог `res` три директории: `drawables`, `vectors`, `icons`.
6. В директории `temp` создайте файл `temp.txt`.

Файл `temp.txt` будет использован для записиси в него информации об успешноном или неуспешном создании файлов и директорий.  

## Реализация

В классе `Main` реализован метод `directoryCreate` с переданым в него классом `StringBuilder`. В этом методе используется `File`, отвечающий за успешное (безуспешное) создание файлов и директорий с дальнейшей записью об этом в `temp.txt`

 ```java
public static void directoryCreate(StringBuilder sb) {
    File dir = new File();
            String dirSuccess = (dir.mkdir() ? dir.getName() + " создан\n" : dir.getName() + " уже был создан или отсутствует\n");
            sb.append(dirSuccess);
}
 ```
 
 Метод `tempWriter`, записывающий файл `temp.txt` о создании файла, дериктории или что они были созданы ранее
 
 ```java
 public static void tempWriter(StringBuilder sb) {
        try () {
            ...
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
```
 
Метод `saveGame()`, реализующий сохранение игры в файл `save.dat`, для записи используется Try-with-resources.

```java
public static void saveGame() {
        GameProgress gameProgress = new GameProgress(100, 1, 1, 100.0);
        try () {
            ...
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
}
```
Метод `zipFilesConvetrter()` реализует архивирование файла `save.dat` в `zip` архив, так же используется try-with-resources

```java
public static void zipFilesConvetrter() {
        try () {
            ...
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
    ```
