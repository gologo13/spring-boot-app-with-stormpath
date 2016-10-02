spring-boot-app-with-stormpath
==============================

## Preparation

1. Create an free account on [Stormpath](https://stormpath.com/).
2. Download your apiKey.properties and put it on `$HOME/.stormpath`.

## How to run

```shell
$ STORMPATH_API_KEY_FILE=~/.stormpath/apiKey.properties \
  STORMPATH_APPLICATION_HREF=<YOUR_APPLICATION_HREF> \
  STORMPATH_AUTHORIZED_GROUP_ADMIN=<YOUR_AUTHORIZED_GROUP_ADMIN_HREF> \
  ./gradlew bootRun
```
