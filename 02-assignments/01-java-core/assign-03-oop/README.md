# Assignment 03 - Session 09 - OOP

![Java](https://img.shields.io/badge/Java-21-orange?logo=openjdk)
![Status](https://img.shields.io/badge/status-completed-brightgreen)

<!-- TOC -->

* [Assignment 03 - Session 09 - OOP](#assignment-03---session-09---oop)
    * [Prerequisites](#prerequisites)
        * [Project Structure](#project-structure)
        * [Environment](#environment)
    * [Questions](#questions)
        * [Câu 1](#câu-1)
        * [Câu 2](#câu-2)
        * [Câu 3](#câu-3)
        * [Câu 4](#câu-4)
        * [Câu 5. Lớp Hệ Thống Điều Hòa và Lớp Máy Sấy:](#câu-5-lớp-hệ-thống-điều-hòa-và-lớp-máy-sấy)
    * [Author](#author)

<!-- TOC -->

## Prerequisites

### Project Structure

```text
D:.
│   .gitignore
│   README.md
└───src
    ├───question01
    │       MainAppQuestion01.java
    │       Student.java
    │
    ├───question02
    │       Car.java
    │       MainAppQuestion02.java
    │
    ├───question03
    │       Game.java
    │       MainAppQuestion03.java
    │
    ├───question04
    │       Car.java
    │       MainAppQuestion04.java
    │       Motorbike.java
    │       Vehicle.java
    │
    └───question05
            AirConditioner.java
            ElectronicDevices.java
            HairDryer.java
            MainAppQuestion05.java
```

### Environment

- IDE: IntelliJ IDEA
- JDK: 21 or higher

## Questions

### Câu 1

- **Đề bài**:
    - Tạo một lớp **HocSinh** (**Student**) để lưu trữ thông tin của một học sinh
    - Bao gồm:
        - Thuộc tính: tên (**fullName**), tuổi (**yob**) và điểm số (**grades**)
        - Phương thức để in thông tin (**printInfo**) và tính điểm trung bình (**calculateAverageGrade**)

- **Class Diagram**:

  ```mermaid
  classDiagram
      class Student{
          - String fullName
          - int yob
          - double[] grades
          
          + void printInfo()
          + int getAge()
          + double calculateAverageGrade()
      }
  ```

### Câu 2

- **Đề bài**:
    - Tạo lớp **XeHoi** (**Car**) để biểu diễn một chiếc xe hơi
    - Các thông tin bao gồm:
        - Thuộc tính: hãng sản xuất (**brand**), màu sắc (**color**), và năm sản xuất (**productionYear**).
        - Phương thức để hiển thị thông tin xe hơi (**printInfo**).

- **Class Diagram**:

    ```mermaid
    classDiagram
        class Car {
            - String brand
            - String color
            - int productionYear
            
            + void printInfo()
        }
    ```

### Câu 3

- **Đề bài**:
    - Tạo lớp **TroChoi** (**Game**) để biểu diễn một trò chơi đơn giản
    - Bạn có thể thêm:
        - Thuộc tính: tên trò chơi (**name**), số lượt chơi (**rounds**)
        - Phương thức: bắt đầu (**startGame**) và kết thúc (**endGame**) trò chơi.

- **Class Diagram**:

    ```mermaid
    classDiagram
        class Game {
            - String name
            - int rounds
            
            + void startGame()
            + void endGame()
        }
    ```

### Câu 4

- **Đề bài**:
    - Lớp cơ sở: **PhuongTienGiaoThong** (**Vehicle**)
    - Lớp con: Xe Hơi (**Car**) và Xe Máy (**Motorbike**)
    - Các lớp có:
        - Thuộc tính: Hãng sản xuất (**brand**), màu sắc (**color**), năm sản xuất (**productoinYear**)
        - Phương thức: Hiển thị thông tin về xe

- **Class Diagram**:

    ```mermaid
    classDiagram
        Vehicle <|-- Car
        Vehicle <|-- Motorbike
        
        class Vehicle {
            <<Abstract>>
            #String brand
            #String color
            #int productionYear
            
            +void printInfo()
            +void getSpeed()*
            +void getTypeDriveLicence()*
        }
    
        class Car{
            -int numSeats
            -String engine
            
            + void openTrunk()
            + void registration()
        }
    
        class Motorbike {
            - double engineCapacity
            
            + void getRestriction()
        }
    ```

### Câu 5. Lớp Hệ Thống Điều Hòa và Lớp Máy Sấy:

- **Đề bài**:
    - Lớp cơ sở: **ThietBiDien** (**ElectronicDevices**)
    - Lớp con: **DieuHoa** (**AirConditioner**) , **MaySay** (**HairDryer**)
    - Các lớp có
        - Thuộc tính liên quan đến thiết bị cụ thể, chẳng hạn như công suất, chức năng (làm lạnh hoặc làm nóng), v.v.
        - Phương thức: Các phương thức đặc biệt cho từng loại thiết bị.

- **Class Diagram**:

    ```mermaid
    classDiagram
        ElectronicDevices <|-- AirConditioner
        ElectronicDevices <|-- HairDryer
        
        class ElectronicDevices {
            <<Abstract>>
            #String brand
            #String name
            #int power
            
            +void printInfo()
            
            +String getType()*
        }
        
        class AirConditioner {
            -int noiseLevel
            -int maxArea
            
            +void getFanSpeed()
        }
        
        class HairDryer {
            -int maxTemperature
            
            +void getMode()
        }
    ```

## Author

Khang Nguyen
