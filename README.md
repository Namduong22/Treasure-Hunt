# Treasure-Hunt
Java Game Project

- Báo cáo BTL và game đã đóng gói: Nằm trong mục Releases

Hướng dẫn cài đặt:

Công cụ yêu cầu:

- XAMPP: https://www.apachefriends.org/download.html

- Eclipse IDE: https://www.eclipse.org/downloads/

- Git: https://git-scm.com/

- java: https://www.oracle.com/java/technologies/downloads/#java8-windows

Các bước thực hiện:

Cài đặt CSDL:

- Bước 1: Khởi động XAMPP Control Panel , click "start" Apache và MySQL
![image](https://user-images.githubusercontent.com/116698926/235676693-8b467f36-a2ca-4810-aef9-9aabccfa1119.png)

  Giao diện sau khi start Apache và MySQL  
![image](https://user-images.githubusercontent.com/116698926/235677101-a98a4015-091a-4612-a080-2c8c859ba724.png)

- Bước 2: CLick vào đường link: http://localhost/phpmyadmin, Nhấn vào SQL
![image](https://user-images.githubusercontent.com/116698926/235678292-d271e1c7-7e32-42a0-be5f-8f288982643a.png)

- Bước 3: Copy và paste đoạn code sau, và ấn thực hiện (go)

		create database if not exists highscores;

		use highscores;

		CREATE TABLE highscore
		(	  
			highscores Double NOT NULL
		);

Cài đặt và chạy game qua Eclipse IDE: 2 Cách

Cách 1: Cài đặt bằng git

- Bước 1: Mở Eclipse IDE.

- Bước 2: Ấn vào File > Import > Git > Projects From Git (with smart import) > Clone URI > Paste link: https://github.com/Namduong22/Treasure-Hunt.git vào phần URI > Next > Chọn vị trí ổ lưu trữ > next > Finish ![image](https://user-images.githubusercontent.com/116698926/235680759-e20cfb4d-63b1-4a0f-b431-8a059baa0baf.png) 

- Bước 3: Chọn folder ![image](https://user-images.githubusercontent.com/116698926/235681745-6837e8ed-7c9a-45f8-bd27-33b8db0ed6ca.png)

Chuột phải chọn Build Path > Configure Build Path > Xuất hiện bảng Properties chọn Java Build Path > Chọn vào dòng như trên ảnh > Chọn Remove 
          
![image](https://user-images.githubusercontent.com/116698926/235682969-0c3655db-df4e-45a5-b4f8-7024bf01303a.png)

- Bước 4: Chọn Modulepath > Click chọn Add External JARS > mở đến folder lib trong thư mục game vừa cài đặt chọn file ![image](https://user-images.githubusercontent.com/116698926/235684597-dd4cb3ad-aa37-4387-82d7-cab5808cbf2f.png) 

- Bước 5: Apply and Close

Cách 2: Cài đặt qua file zip

- Bước 1: Tải bản ZIP về máy.

- Bước 2: Giải nén bản ZIP.

- Bước 3: Mở Eclipse IDE, chọn File/Open Projects from File System.../Directory

- Bước 4: Chọn folder game vừa giải nén, rối nhấn Finish.

- Bước 5: Thực hiện tương tự bước 3, 4 ở cách 1.

Hướng dẫn chạy game: 

Cách 1:

- Bước 1: Thực hiện đầy đủ các bước cài đặt CSDL.

- Bước 2: Giải nén thư mục Bao-Cao-Game.rar đã tải trong phần releases, chạy file TreasureHunt.jar.

Cách 2:

- Bước 1: Thực hiện đầy đủ các bước cài đặt CSDL.

- Bước 2: chuột phải folder game trong Eclipse IDE chọn Run as > Java application > OK

![image](https://user-images.githubusercontent.com/116698926/235686161-f3e2de91-ad28-4352-87cc-0fc7e7f60333.png)
