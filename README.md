# 112學年度物件導向程式語言設計期末指定題作業
此頁面主要紀錄台灣大學工程科學及海洋工程學系黃乾綱教授於112學年度第二學期開設的物件導向程式語言(Object Oriented Programming Language)課程。\
本項作業為指定題：Youbike Rental System

以下簡介本系統之架構圖(hierarchy):
<pre>
youbike_rental_project/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.youbikerental/
│   │   │       ├── config/
│   │   │       │   └── SecurityConfig.java         # 安全配置
│   │   │       ├── controller/
│   │   │       │   ├── MainController.java         # 處理整體請求
│   │   │       │   ├── UserController.java         # 處理用戶相關請求
│   │   │       │   ├── BikeController.java         # 處理自行車相關請求
│   │   │       │   ├── StationController.java      # 處理站點相關請求
│   │   │       │   ├── PostController.java         # 處理車柱相關請求
│   │   │       │   ├── RentalController.java       # 處理租借記錄相關請求
│   │   │       │   └── EasyCardController.java     # 處理儲值卡相關請求
│   │   │       ├── model/
│   │   │       │   ├── User.java                   # 用戶模型
│   │   │       │   ├── Bike.java                   # 自行車模型
│   │   │       │   ├── Station.java                # 站點模型
│   │   │       │   ├── Post.java                   # 車柱模型
│   │   │       │   ├── Rental.java                 # 租借記錄模型
│   │   │       │   └── EasyCard.java               # 悠遊卡模型
│   │   │       ├── repository/
│   │   │       │   ├── UserRepository.java         # 用戶數據存儲庫
│   │   │       │   ├── BikeRepository.java         # 自行車數據存儲庫
│   │   │       │   ├── StationRepository.java      # 站點數據存儲庫
│   │   │       │   ├── PostRepository.java         # 車柱數據存儲庫
│   │   │       │   ├── RentalRepository.java       # 租借記錄數據存儲庫
│   │   │       │   └── EasyCardRepository.java     # 悠遊卡數據存儲庫
│   │   │       ├── service/
│   │   │       │   ├── UserService.java            # 用戶相關業務邏輯
│   │   │       │   ├── BikeService.java            # 自行車相關業務邏輯
│   │   │       │   ├── StationService.java         # 站點相關業務邏輯
│   │   │       │   ├── PostService.java            # 車柱相關業務邏輯
│   │   │       │   ├── RentalService.java          # 租借記錄相關業務邏輯
│   │   │       │   └── EasyCardService.java        # 悠遊卡相關業務邏輯
│   │   │       └── YoubikeRentalApplication.java   # Spring Boot 應用入口
│   │   └── resources/
│   │       ├── templates/                          # Thymeleaf 模板目錄
│   │       │   ├── index.html                      # 主頁面
│   │       │   ├── login.html                      # 登入頁面
│   │       │   ├── register.html                   # 註冊頁面
│   │       │   ├── stations.html                   # 站點查詢
│   │       │   ├── rent.html                       # 租車介面
│   │       │   ├── return.html                     # 還車介面
│   │       │   ├── topup.html                      # 儲值介面
│   │       │   ├── history.html                    # 租借記錄
│   │       │   ├── search.html                     # 站點搜索
│   │       │   ├── detail.html                     # 站點詳情
│   │       │   ├── contact.html                    # 聯繫官方
│   │       │   ├── dashboard.html                  # 管理員控制台
│   │       │   └── map.html                        # 地圖介面
│   │       ├── application.properties              # 應用配置文件
│   │       └── static/                             # 靜態資源，如 CSS, JavaScript
│   └── test/                                       # 測試目錄
│       └── java/
│           └── com.youbikerental/
│               ├── UserControllerTest.java         # 用戶控制器測試
│               └── UserServiceTest.java            # 用戶服務測試
└── pom.xml                                         # Maven 配置文件


</pre>