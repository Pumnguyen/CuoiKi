XÂY DỰNG WEBSITE BÁN MÔ HÌNH GUNDAM UTESHOP

1. Thông tin sinh viên  
Họ và tên: Nguyễn Lê Quang Trường  
MSSV: 22110258  
Lớp: 22110CLIS1  

2. Giới thiệu đề tài  
Đề tài “Xây dựng Website Bán Mô Hình Gundam UTESHOP” được thực hiện nhằm mô phỏng một hệ thống thương mại điện tử quy mô nhỏ, cho phép người dùng thực hiện các thao tác cơ bản của một website bán hàng như: xem sản phẩm, đăng ký và đăng nhập tài khoản, thêm sản phẩm vào giỏ hàng, đặt hàng và thanh toán trực tuyến.  

Phía quản trị viên có thể quản lý danh mục sản phẩm, thông tin người dùng, kiểm tra đơn hàng và theo dõi thống kê doanh thu. Hệ thống hướng đến mục tiêu tạo ra một website hoàn chỉnh, có tính thực tế cao, đáp ứng nhu cầu học tập và thực hành kỹ năng lập trình web bằng ngôn ngữ Java.  


3. Mục tiêu của hệ thống  
- Xây dựng một website thương mại điện tử hoạt động ổn định và thân thiện với người dùng.  
- Áp dụng các công nghệ Java Servlet, JSP, Hibernate, JDBC trong việc xây dựng hệ thống web.  
- Tích hợp chức năng thanh toán trực tuyến bằng VNPay (môi trường thử nghiệm TryItNow).  
- Xây dựng cơ chế xác thực và phân quyền người dùng bằng JWT.  
- Cung cấp giao diện quản trị dễ sử dụng, có thể thêm, sửa, xóa dữ liệu (CRUD).  


4. Công nghệ và công cụ sử dụng  

| Thành phần                    Công nghệ sử dụng               |
|--------------------------|------------------------------------|
| Ngôn ngữ lập trình       | Java (JDK 17)                      |
| Framework                | Servlet, JSP, Hibernate            |
| Giao diện                | HTML5, CSS3, Bootstrap 5, JSTL     |
| Cơ sở dữ liệu            | MySQL 8.0                          |
| Máy chủ ứng dụng         | Apache Tomcat 10.1                 |
| Thư viện hỗ trợ          | JWT, VNPay API, Sitemesh Decorator |
| IDE                      | Eclipse                            |
| Hệ điều hành phát triển  | Windows 10                         |


5. Cấu trúc dự án  

DAWEBB/
│
├── src/main/java/me/quangtruong/
│   ├── controller/
│   │   ├── HomeController.java
│   │   ├── ProductManagerController.java
│   │   └── VNPAYController.java
│   ├── entity/
│   │   ├── Product.java
│   │   ├── ProductCategory.java
│   │   ├── Users.java
│   │   ├── Orders.java
│   │   ├── Transaction.java
│   │   └── Rating.java
│   ├── dao/
│   └── jwt/
│
├── webapp/
│   ├── views/
│   │   ├── home.jsp
│   │   ├── shop.jsp
│   │   ├── admin/
│   │   │   ├── dashboard.jsp
│   │   │   └── analytics.jsp
│   ├── assets/
│   │   ├── css/
│   │   ├── js/
│   │   └── images/
│   └── WEB-INF/
│       ├── web.xml
│       └── sitemesh.xml
│
├── pom.xml
└── README.md

6. Hướng dẫn cài đặt và chạy dự án  

Bước 1: Cấu hình môi trường  
- Cài đặt JDK 17 
- Cài đặt Apache Tomcat 10.1 
- Cài đặt MySQL 8.0 
- Cài đặt Eclipse IDE for Enterprise Java Developers

Bước 2: Import project  
- Mở Eclipse → Chọn **File → Import → Existing Maven Project**  
- Trỏ đến thư mục dự án (ví dụ: `DAWEBB/`)

Bước 3: Cấu hình cơ sở dữ liệu  
Tạo cơ sở dữ liệu trong MySQL bằng lệnh:
sql
CREATE DATABASE uteshop;

Sau đó import file `uteshop.sql` vào cơ sở dữ liệu.  
Mở file `hibernate.cfg.xml` và sửa thông tin kết nối MySQL phù hợp với máy của bạn (username, password).

Bước 4: Cấu hình VNPay (môi trường TryItNow)  
Mở file `vnpay_config.properties` và điền như sau:
properties
vnp_TmnCode=UTESHOPTEST
vnp_HashSecret=UTESHOP_SECRET_123
vnp_Url=https://sandbox.vnpayment.vn/tryitnow/Home/CreateOrder
vnp_Returnurl=http://localhost:8080/DAWEBB/vnpay_return

VNPay sẽ thực hiện mô phỏng giao dịch trực tuyến và trả kết quả về servlet `VNPAYController.java`.

Bước 5: Khởi chạy ứng dụng  
- Add server Tomcat v10.1  
- Run project → “Run on Server”  
- Mở trình duyệt và truy cập địa chỉ:  
  `http://localhost:8080/DAWEBB/home`

7. Các chức năng chính  

Người dùng  
- Đăng ký và đăng nhập tài khoản  
- Xem chi tiết sản phẩm và danh mục  
- Thêm sản phẩm vào giỏ hàng  
- Thanh toán thử nghiệm bằng VNPay (TryItNow)  
- Đánh giá sản phẩm sau khi mua hàng  

Quản trị viên  
- Quản lý sản phẩm, danh mục và người dùng  
- Theo dõi đơn hàng, doanh thu, trạng thái giao dịch  
- Trang thống kê hiển thị số liệu tổng hợp  

8. Mô hình cơ sở dữ liệu  

Các bảng chính:
- Users (UserId, UserFullName, UserPhone, UserEmail, UserAddress, UserPassword, UserIsAdmin, UserImage, UserRegisDay)  
- Product (ProductId, ProductName, ProductImage, ProductPrice, ProductAmount, ProductCategoryId)  
- ProductCategory (ProductCategoryId, ProductCategoryName)  
- Orders (OrderId, OrderPrice, OrderCount, OrderStatus, UserId, ProductId)  
- Transaction (TransId, TransDay, TransAddress, TransStatus, TransTotalValue, UserId)  
- Rating (RatingId, RatingDate, RatingValue, RatingComment, ProductId, UserId)  

Các mối quan hệ:  
- Users – Orders: 1-nhiều  
- ProductCategory – Product: 1-nhiều  
- Product – Rating: 1-nhiều  
- Users – Transaction: 1-nhiều  

9. Kết quả đạt được  
- Website hoạt động ổn định với đầy đủ chức năng quản lý và thanh toán thử nghiệm.  
- Giao diện thiết kế hiện đại, dễ sử dụng.  
- Cấu trúc code tuân theo mô hình MVC rõ ràng.  
- Kết nối cơ sở dữ liệu và xử lý nghiệp vụ thông suốt.  


