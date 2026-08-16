# Linux Lab

- [Linux Lab](#linux-lab)
  - [Common Command](#common-command)
  - [Author](#author)

## Common Command

- `pwd`: lấy ra đường dẫn hiện tại

- `cd <option>`: di chuyển terminal qua folder khác, `<options>`:
  - `.` : thư mục hiện tại
  - `..` : thư mục cha
  - `-` : thư mục vừa truy cập
  - `~` : thư mục cá nhân
  - `foldername` : đang đứng ở đâu thì nối đuôi
  - `/foldername` : ra gốc đi vào, đường dẫn tuyệt đối

- `ls <option>`: liệt kê thư mục và file, `<options>`:
  - `l`: hiển thị chi tiết
  - `a`: hiển thị file ẩn
  - `h`: kích thước dễ đọc

- Đọc thông tin từ ls, ví dụ: `drwxr-xr-x`
  - Định dạng:
    - `d` : folder/directory
    - `l` : symbol link
    - `-`: Trống/Empty: file
  - Phân quyền file/folder
    - rwx: chủ sở hữu
    - r-x: nhóm
    - r-x: người khác
  - Ví dụ: `-rw-r--r-- 1 ngkhang 197121 21 Jul 14 11:16 README.md`
    - `-`: file
    - `rw-`: quyền người sở hữu
    - `r--`: quyền của nhóm
    - `r--`: quyền của người khác
    - `1`: có 1 hard link trong thu muc
    - `ngkhang`: người sở hữu
    - `197121`:

- Thao tác với file/folder
  - Tạo folder:
    - `mkdir <FolderName>`: Tạo thư mục `<FolderName>`
    - `mkdir -p <ParentFolder/ChildFolder>`: Tạo các thư mục cha nếu chưa tồn tại
  - Tạo file: `touch <FileName>`
  - Ghi nội dung vào file:
    - `echo <Content> > <FileName>`: Ghi đè nội dung
    - `echo <Content> >> <FileName>`: Ghi thêm nội dung vào bên dưới
  - Di chuyển: `mv <File/Folder> <Destination>`
  - Xóa
    - `rmdir`: xóa folder trống, `-r`: xóa folder có nội dung bên trong
    - `rm`: xóa file
  - Copy:
    `cp <File/Folder old des> <new_des>`: copy file/folder
    `cp -r <File/Folder old des> <new_des>`: copy file/folder cùng nội dung bên trong

- Tìm kiếm nội dung - GREP `grep`

  ```bash
  grep -<i|n|r> <Content> <FileName>
  ```

  - `i`: không phân biệt hoa thường
  - `n`: số dòng
  - `r`: tìm đệ quy

- Tìm file - `find`

  ```bash
  find . -iname <filename>
  ```

- Kiểm tra tiến trình:

  ```bash
  > ps

    PID    PPID    PGID     WINPID   TTY         UID    STIME COMMAND
    1767    1715    1767      18360  cons0     197609 00:10:09 /usr/bin/ps
    1715       1    1715      22556  cons0     197609 23:52:19 /usr/bin/bash
  ```

## Author

- Khang Nguyen
