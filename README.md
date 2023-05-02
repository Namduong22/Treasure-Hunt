# Treasure-Hunt
Java Game Project

Hướng dẫn cài đặt:

Công cụ yêu cầu:

- Bộ cài XAMPP sẽ kèm theo PHP MyAdmin: https://www.apachefriends.org/download.html

- Eclipse IDE: https://www.eclipse.org/downloads/

- Git: https://git-scm.com/

Các bước thực hiện:

Cài đặt CSDL:

- Bước 1: Khởi động XAMPP, start Apache và MySQL
![image](https://user-images.githubusercontent.com/116698926/235676693-8b467f36-a2ca-4810-aef9-9aabccfa1119.png)
  Giao diện sau khi start Apache và MySQL
![image](https://user-images.githubusercontent.com/116698926/235677101-a98a4015-091a-4612-a080-2c8c859ba724.png)

-Bước 2: CLick vào đường link: http://localhost/phpmyadmin, Nhấn vào SQL
![image](https://user-images.githubusercontent.com/116698926/235678292-d271e1c7-7e32-42a0-be5f-8f288982643a.png)
Copy và paste đoạn code sau, và ấn thực hiện (go)

create database if not exists highscores;

use highscores;

CREATE TABLE highscore

(	  

	highscores Double NOT NULL
  
);

Cài đặt và chạy game qua Eclipse IDE:

- Bước 1: Mở Eclipse IDE.

- Bước 2: Ấn vào File > Import > Git > Projects From Git (with smart import) > Clone URI > Paste link: https://github.com/Namduong22/Treasure-Hunt.git vào phần URI > Next > Chọn vị trí ổ lưu trữ > next > Finish ![image](https://user-images.githubusercontent.com/116698926/235680759-e20cfb4d-63b1-4a0f-b431-8a059baa0baf.png) 

- Bước 3: Chọn ![image](https://user-images.githubusercontent.com/116698926/235681745-6837e8ed-7c9a-45f8-bd27-33b8db0ed6ca.png)

Chuột phải chọn Build Path > Configure Build Path > Xuất hiện bảng Properties chọn Java Build Path > Chọn vào dòng như trên ảnh > Chọn Remove 
          
![image](https://user-images.githubusercontent.com/116698926/235682969-0c3655db-df4e-45a5-b4f8-7024bf01303a.png)

- Bước 4: Chọn Modulepath > Click chọn Add External JARS > mở đến folder lib trong thư mục game vừa cài đặt chọn file ![image](https://user-images.githubusercontent.com/116698926/235684597-dd4cb3ad-aa37-4387-82d7-cab5808cbf2f.png) 

- Apply and Close

- Chạy game: Chuột phải chọn Run as > Java application > OK
![image](https://user-images.githubusercontent.com/116698926/235686161-f3e2de91-ad28-4352-87cc-0fc7e7f60333.png)



