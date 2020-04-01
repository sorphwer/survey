# Survey
<!-- TOC -->

- [Survey](#survey)
  - [Installation](#installation)
  - [Usage](#usage)
    - [Question json format](#question-json-format)
    - [DB Structure](#db-structure)
      - [TABLE Survey](#table-survey)
      - [TABLE answer](#table-answer)
  - [Contributing](#contributing)
  - [License](#license)

<!-- /TOC -->
Survey is an Android Application based on Java.

The basic thought is to generate a serious of pages of different question types, to let users fill their answers. And save all the answers in the end. The answers will also include `IMEI`(if target devices’ API level allows that, otherwise it will be `null`), timestamp, and  location information.(Gifs below are not the final release version)

![image](https://github.com/sorphwer/survey/blob/master/assets/IMG_6864.GIF)


Survey also contains:

- Questionnaire Editor
- Support import Questionnaires via QR code: Camera/Album
- Questionnaires Manager.
- Language Support : Chinese, English



## Installation

To run with the source code, you need to install [Android Studio] and import the root folder. (https://developer.android.com/studio).

The min SDK version is `20` and SDK version `29` is recommended.

## Usage

### Question json format

Every survey’s question is imported as `json` string, the standard format is:

    ```json
    {
      "survey": {
        "id": "00001",
        "len": 3,
        "questions": [
          {
            "type": "single",
            "question": "How well do the professors teach at this university?",
            "options": [
              {"1": "Extremely well"},
              {"2": "Very well"}
            ]
          },
          {
            "type" : "multiple",
            "question": "Which of the following courses do you like?",
            "options": [
              {"1": "Mathematics"},
              {"2": "Literature"},
              {"3": "Computer"},
              {"4": "Physics"},
              {"5": "Linguistics"}
            ]
          },
          {
            "type": "fill-in",
            "question": "What do you suggest for the school?"
          }
        ]
      }
    }
    ```

To get the sample QR code for this, please visit :https://android-lab-group-1.github.io/ 

Also, there’s a online questionnaire editor : http://xiaonan.ngrok2.xiaomiqiu.cn/server/ 

### DB Structure

#### TABLE Survey

| col integer INT | col surveyID TEXT | col surveyJsonString TEXT |
| --------------- | ----------------- | ------------------------- |
| (increasing)    |                   |                           |

#### TABLE answer

| col id INT | col latitude DOUBLE | col timestamp DOUBLE | col sync INT | col IMEI char(20) | col answer TEXT |
| ---------- | ------------------- | -------------------- | ------------ | ----------------- | --------------- |
|            |                     |                      | 0            |                   |                 |

## Contributing

**This application is based on a team work “[survey](https://github.com/Android-Lab-Group-1/Survey)”**

 Used modules:  [zxing](https://github.com/zxing/zxing) for QR scanner. And baoyz’s  [swipemenulistview](https://github.com/baoyongzhang/SwipeMenuListView)

You can manage them on `gradle` config file :

```
implementation 'com.github.yuzhiqiang1993:zxing:2.2.5'
implementation 'com.baoyz.swipemenulistview:library:1.3.0'
```

To edit list view , please check the doc of [RecyclerView](https://developer.android.google.cn/guide/topics/ui/layout/recyclerview#java)



## License

[MIT](https://choosealicense.com/licenses/mit/) will be added at the first released version.