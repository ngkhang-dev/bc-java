# Docker Lab

- [Docker Lab](#docker-lab)
  - [Concepts](#concepts)
    - [Docker Engine](#docker-engine)
    - [Docker Image](#docker-image)
    - [Docker Container](#docker-container)
    - [Docker Volume](#docker-volume)
  - [Khởi tạo MySQL từ Docker](#khởi-tạo-mysql-từ-docker)
  - [Author](#author)

## Concepts

### Docker Engine

- Quản lý toàn bộ Image, Container, Volume, network trong Docker

### Docker Image

- Bản đóng gói sẵn, dùng để tạo container, như một "khung class" để tạo ra nhiều "object/instance"

```bash
# Kiểm tra danh sách Image đang có
docker image ls

# Tải Image từ Docker Hub
docker pull <image_name>:<version>

# Xóa Image
docker rmi <image_name_or_id>

# Tạo Docker Container
docker run --rm <image_name>
```

### Docker Container

- Container là một "instance/object" được tạo từ Docker Image và đang ở một trạng thái cụ thể.
- Container độc lập với Image
- Mỗi Container sẽ có Port riêng khi chạy

```bash
# Chạy container
docker start <container_name_or_id>

# Dừng container
docker stop <container_name_or_id>

# Dừng tất cả Container
docker stop $(docker ps -q)

# Xóa container
docker rm <container_name_or_id>
```

### Docker Volume

- Nơi lưu trữ các thông tin để container tham chiếu
- Khi Container bị xóa, các dữ liệu trên Volume không bị xóa

## Khởi tạo MySQL từ Docker

```bash
# Tải Docker Image MySQL version 8.4 từ Docker Hub
docker pull mysql:8.4

# Tạo container từ Image
docker run --name mysql-java14 -e MYSQL_ROOT_PASSWORD=Root@1234 -e MYSQL_DATABASE=java_14_class -e MYSQL_USER=java_user -e MYSQL_PASSWORD=Java@1234 -p 3307:3306 -d mysql:8.4

# Kiểm tra truy cập
docker exec mysql-java14 mysqladmin ping -uroot -pRoot@1234
# docker exec: Chạy lệnh trong container đang hoạt động
# mysqladmin: công cụ của MySQL
# ping : kiểm tra phản hồi

docker exec -it mysql-java14 mysql -uroot -pRoot@1234
# -it: tương tác trong terminal container
```

## Author

- Khang Nguyen
