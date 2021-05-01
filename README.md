# function-sample-aws

Spring Cloud FunctoionとAWSで色々試す。

- [x] 公式サンプルのSpring Cloud Function動かしてみる
- [x] SAM適用してデプロイ楽にする
- [x] 関数2つ以上作成して、任意の方を実行する
- [ ] Cloudwatch Eventsと連携してみる
  - 0時に関数実行をスケジューリングする
- [ ] s3イベントと連携してみる
  - ファイル名、中身、配置した人、配置した時間を出力する

## メモ

* template.yamlに環境変数埋め込んでないと、環境変数上書きできない
* ただ関数として動かしたいだけであれば、spring-cloud-function-webとかstreamとかいらない
* ローカル開発環境でIDE使ってSAMでデバックとかしたかったけど、eclipseのAWS-toolkitはなんかうまく動かなかった
  * リリースが2018でもうメンテされていない。2021年でもまだメンテされているintelij/vscode使った方が良い。
  *  vscodeは、まだJava対応していないっぽい。。
     *  https://docs.aws.amazon.com/toolkit-for-vscode/latest/userguide/serverless-apps.html
  *  Intelijなら普通にできた。