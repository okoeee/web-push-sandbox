# WebPushSandboxApp

## VAPID鍵の生成
```shell
npm install web-push -g
web-push generate-vapid-keys
```

## ローカルサーバーを立ててプロダクションビルド成果物を配信する
```shell
npm run watch.prod
npm run serve
```

## Push通知を送信する

```shell
  web-push send-notification  \
  --endpoint=https://fcm.googleapis.com/fcm/send/d61c5u920dw:APA91bEmnw8utjDYCqSRplFMVCzQMg9e5XxpYajvh37mv2QIlISdasBFLbFca9ZZ4Uqcya0ck-SP84YJUEnWsVr3mwYfaDB7vGtsDQuEpfDdcIqOX_wrCRkBW2NDWRZ9qUz9hSgtI3sY \
  --key=BL7ELU24fJTAlH5Kyl8N6BDCac8u8li_U5PIwG963MOvdYs9s7LSzj8x_7v7RFdLZ9Eap50PiiyF5K0TDAis7t0 \
  --auth=juarI8x__VnHvsOgfeAPHg \
  --vapid-subject=mailto:example@qq.com \
  --vapid-pubkey=BGtkbcjrO12YMoDuq2sCQeHlu47uPx3SHTgFKZFYiBW8Qr0D9vgyZSZPdw6_4ZFEI9Snk1VEAj2qTYI1I1YxBXE \
  --vapid-pvtkey=I0_d0vnesxbBSUmlDdOKibGo6vEXRO-Vu88QlSlm5j0 \
  --payload=Hello
```
