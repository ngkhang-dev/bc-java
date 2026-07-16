# Assignment 03 - Session 09 - OOP

## Câu 1

- **Đề bài**:
    - Tạo một lớp **HocSinh** (**Student**) để lưu trữ thông tin của một học sinh
    - Bao gồm:
        - Thuộc tính: tên (**fullName**), tuổi (**yob**) và điểm số (**grades**)
        - Phương thức để in thông tin (**printInfo**) và tính điểm trung bình (**calculateAverageGrade**)

- Solution:

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

## Câu 2

- **Đề bài**:
    - Tạo lớp **XeHoi** (**Car**) để biểu diễn một chiếc xe hơi
    - Các thông tin bao gồm:
        - Thuộc tính: hãng sản xuất (**brand**), màu sắc (**color**), và năm sản xuất (**productionYear**).
        - Phương thức để hiển thị thông tin xe hơi (**printInfo**).

- Solution:
    ```mermaid
    classDiagram
        class Car {
            - String brand
            - String color
            - int productionYear
            
            + void printInfo()
        }
    ```

## Câu 3

- **Đề bài**:
    - Tạo lớp **TroChoi** (**Game**) để biểu diễn một trò chơi đơn giản
    - Bạn có thể thêm:
        - Thuộc tính: tên trò chơi (**name**), số lượt chơi (**rounds**)
        - Phương thức: bắt đầu (**startGame**) và kết thúc (**endGame**) trò chơi.

- Solution:

    ```mermaid
    classDiagram
        class Game {
            - String name
            - int rounds
            
            + void startGame()
            + void endGame()
        }
    ```

## Câu 4

- **Đề bài**:
    - Lớp cơ sở: **PhuongTienGiaoThong** (**Vehicle**)
    - Lớp con: Xe Hơi (**Car**) và Xe Máy (**Motorbike**)
    - Các lớp có:
        - Thuộc tính: Hãng sản xuất (**brand**), màu sắc (**color**), năm sản xuất (**productoinYear**)
        - Phương thức: Hiển thị thông tin về xe

- Solution:

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

## Câu 5. Lớp Hệ Thống Điều Hòa và Lớp Máy Sấy:

- **Đề bài**:
    - Lớp cơ sở: **ThietBiDien** (**ElectronicDevices**)
    - Lớp con: **DieuHoa** (**AirConditioner**) , **MaySay** (**HairDryer**)
    - Các lớp có
      - Thuộc tính liên quan đến thiết bị cụ thể, chẳng hạn như công suất, chức năng (làm lạnh hoặc làm nóng), v.v.
      - Phương thức: Các phương thức đặc biệt cho từng loại thiết bị.

- Solution:

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