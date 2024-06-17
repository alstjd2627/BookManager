## 😎 역할 분담

강민혁(C011215) : search_bs() 구현

김민성(C011217) : junit search_bs() test

김다희(B935042) : performance_test() 구현, test

## 🤯 git 트러블 슈팅

### 디폴트 브랜치명을 master → main 으로 변경

![image](https://github.com/alstjd2627/BookManager/assets/119108655/41bc3e68-3398-4272-817b-bb7d0305e3ac)

github repository나 처음 git을 연동시킬 때, 기본 branch 명은 master였는데, 이게 과거 노예제도를 연상시킨다 해서 master라 하지 않고 main으로 바꾸도록 권장하고 있다. 로컬에서 git init을 한 후 커밋을 하면 기본 branch 명이 master가 되는데, github에 push 할 경우 master과 main 브랜치 2개가 동시에 존재 할 수 있기때문에 초기에 로컬과 원격 모두 main으로 변경해 두었다.

## 🤯 Jenkins 트러블 슈팅

### Jenkinsfile 파일명을 잘못 입력하여 오류가 났음.

![image](https://github.com/alstjd2627/BookManager/assets/119108655/396c6ecc-a830-4ba1-bcd4-1ff68f36c835)

![image](https://github.com/alstjd2627/BookManager/assets/119108655/d0e987da-a037-429d-807a-01e2fd8526f2)


### IDE 변경에 의한 라이브러리 세팅 오류

eclips 대신 intelliJ IDE를 사용해 보고싶었다. 이클립스는 자동으로 설정해주지만 intelliJ로 J unite test를 하기 위해서는 gradle 또는 maven lib를 따로 설정해 주어야 하는데, 이 과정에서 test 오류가 났다.

또한 팀원들이 맥과 윈도우를 모두 사용하고 있어 사소한 문법 오류도 겪었다.

1) gradle 라이브러리로 해결하고자 함

<img width="912" alt="image" src="https://github.com/alstjd2627/BookManager/assets/119108655/eff6df5a-84d6-49e6-9193-bcfc46adf242">
버전 오류인 것 같아 여러번 재시도 → 실패

2) maven 라이브러리로 해결하고자 함
   ![image](https://github.com/alstjd2627/BookManager/assets/119108655/d3befa63-3c3d-430b-a81a-58d6dfdc8414)
   테스트 오류
   ![image](https://github.com/alstjd2627/BookManager/assets/119108655/0fda10c0-8b34-4510-bcfc-c4e306355da3)
   .txt 파일 생성 오류 → maven은 .xml 파일 기본 생성
3) maven의 target을 바꿔줌 -> txt 파일 생성


## 😎결과 화면(output log)
![image](https://github.com/alstjd2627/BookManager/assets/119108655/4d74c693-b2df-4a2a-b04d-0ecb710a5276)
![image](https://github.com/alstjd2627/BookManager/assets/119108655/3bb0727e-2c6f-485e-9242-3da26a871112)
![image](https://github.com/alstjd2627/BookManager/assets/119108655/43cf0f72-1ddf-487c-8ffd-ec564403e16f)
![image](https://github.com/alstjd2627/BookManager/assets/119108655/ab59056a-2ac6-49a8-a9d1-678baae7af3d)
![image](https://github.com/alstjd2627/BookManager/assets/119108655/0c303900-9d92-4345-9ec4-e0f25c7197bb)
![image](https://github.com/alstjd2627/BookManager/assets/119108655/733eaf96-71e9-45ab-afe8-b6359f27c686)
![image](https://github.com/alstjd2627/BookManager/assets/119108655/b17a12b1-892c-4bca-8f14-8efa18323418)

## 🔗 깃허브 주소

[https://github.com/alstjd2627/BookManager.git](https://github.com/alstjd2627/BookManager.git)
