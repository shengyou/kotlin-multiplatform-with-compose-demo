# 《Compose for Desktop - 開發桌面軟體的新選擇》Desktop 範例程式碼

這個 Repository 是在「[JCConf 2023](https://jcconf.tw/2023/)」分享《從 Kotlin Multiplatform 到 Compose Multiplatform：在多平台間輕鬆共用業務邏輯與 UI 介面 》的範例程式碼，完整說明請參考簡報。

## 相關資源

* 簡報檔：https://www.slideshare.net/shengyou/kotlin-multiplatform-with-compose
* 原始碼：https://github.com/shengyou/kotlin-multiplatform-with-compose-demo

### 警告！

#### 這個範例程式碼僅是配合投影片上的展示而撰寫，範例內為配合概念演示，程式碼並非最佳實踐、程式內的諸多功能、錯誤處理也不完整，目的僅是做為概念驗證。請勿將這個程式碼佈署至上線機器，若因此造成您的損失恕不負責。

## 執行指南

1. 使用 kdoctor 確認你的環境，沒有 kdoctor 的話，可以透過 '$ brew install kdoctor' 下載
2. 確認有沒有可以掛載 proxy 的工具，這邊使用 ngrok 示範，可以透過 '$ brew install ngrok' 下載
3. 程式碼預設是掛載在 8080 port，在命令列輸入 '$ ngrok http 8080'
4. 將 Forwarding 欄位的 url 複製, ex: "https://XXXX-XXX-XXX-XXX-XX.ngrok.io"
5. 在專案內的 Urls.kt 檔案內，將 apiBaseUrl 的值貼上
6. 運行後端，在 server 資料夾下的 Application.kt，可以利用 IDE 的功能運行，或是指令 '$ ./gralew :server:run'
7. 接著就可以在前端測試，可以點選 IDE 上方的 configuration 切換要運行的平台，再點選 Build 即可
