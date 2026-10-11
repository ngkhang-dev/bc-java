# Git and GitHub note

- [Git and GitHub note](#git-and-github-note)
  - [Introduction](#introduction)
  - [Author](#author)

## Introduction

- `git --version` : kiểm tra phiên bản
- `git config --global user.name "your_name"`
- `git config --global user.email "your_github_email"`
- `git init` : khởi tạo project sử dụng git cho dự án
- `git remote add origin duong_dan_https` : kết nối folder trong máy với remote repo
- `git branch` : kiểm tra nhánh hiện tại
- `git checkout <ten_branch>` : đổi qua nhánh khác
- `git checkout -b <ten_branch>` : tạo và chuyển sang nhánh mới. Lưu ý: sẽ tạo nhánh mới từ nhánh mình đang đứng
- `git fetch` : xem các thay đổi trên remote repo về local repo - chưa merge vào local repo (case: update nhánh mới để tiến hành checkout)
- `git merge <ten_branch>`: đang đứng ở nhánh A, kéo code từ nhánh <ten_branch> về nhánh A
  - Nếu không có CONFLICT -> `git push`
  - Nếu có CONFLICT -> xử lý CONFLICT -> `git add .`, `git commit`, `git push`
- `git pull` : lấy code từ remote repo và merge vào local remote, `git pull` = `git fetch` + `git merge`
  - `git pull --no-rebase` : kéo code về bằng cách truyền thống, không viết lại lịch sử
  - `git pull rebase`: `viết lại lịch sử`
- `git push` : đẩy code từ local repo lên remote repo tại branch đang đứng
  - `git push -u origin <ten_branch>` : khi đẩy code lần đầu tiên của branch
  - `git push --force`: override remote repo, lấy local repo làm chuẩn, bỏ qua mọi khác biệt mà git cảnh báo
- `git add .` : thêm file vào danh sách theo dõi (staging area)
  - `git add .` : thêm tất cả file đang có thay đổi
  - `git add <ten_file>` : thêm 1 file cụ thể
- `git commit -m "noi_dung_message'` : "snapshot" code ở thời điểm thao tác

## Author

Khang Nguyen
