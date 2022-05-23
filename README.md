# kmu_bus_nfc_application
계명대학교 스쿨버스통합어플리케이션 캡스톤 디자인 프로젝트
학교 캡스톤 디자인 프로젝트에 만든 프로그램으로 Android를 통해 학교 내의 스쿨버스를 편안하게 이용할 수 있는 APP입니다.
Android java기반으로 만들어져 있으며 서버는 웹서버의 DB는 MySql를 사용하였으며 웹서버와의 통신을 위해 중간에 PHP를 활용해서 전달됩니다.
PHP코드, Android 코드가 따로 들어가 있습니다.

1. 만들게 된 계기: 
현재 학교 통학버스는 집에서 학교까지 장거리 통학을 하는 학생들이 통학 버스를 많이 이용 하는데, 별도의 예약 체계가 없이 선착순으로 버스를 탑승하기에 직접 가서 잔여 좌석 여부를 확인해야 한다. 이러한 이유로 통학버스를 이용하는 학생들이 버스 탑승을 위한 대기시간이 길고, 실제로 그 긴 시간을 기다렸음에도 불구하고 통학버스가 만원이 되어 탑승하지 못하는 경우, 버스 정거장과 거리가 먼 강의실에서 왔음에도 버스 좌석이 없어 탑승하지 못하는 경우가 많다.

2. 목적 및 필요성: 
스쿨버스 통합관리 어플리케이션은 위 현황에 작성한 문제들을 해결하는 것을 목적으로 한다. 문제 해결을 위해 학생들에게 통학버스의 잔여 좌석과 현재 위치 또는 시간 등의 정보를 제공하여 기존에 겪는 불편사항을 해소하고, 또한 학교에서 전달하는 버스의 중요한 공지사항을 직접적으로 받을 수 있도록 한다. 그로인해 문제점으로 지적받는 긴 대기시간과 오랜 시간을 대기하였으나 후 탑승을 못하는 상황을 해결 할 수 있어 현재 학생들 겪는 불편함을 해소하고 건의사항 항목을 통해 학생들의 추가적인 불만이나 요구를 만족시킬 수 있다. 그리고 학교 차원에서는 스쿨버스 통합관리 어플리케이션을 통해 누적되는 데이터를 통해 버스 노선 및 버스 대수의 관리에 대한 용이성을 얻을 수 있으며, 학교 차원을 넘어 일반 기업, 학원 등 통학버스를 운영하는 시설에서도 사용이 가능하다. 

3. 기능
App 
회원 기능
- 건의 : 회원이 App을 사용하며 생기는 건의사항을 입력 받아 DB로 전송하는 기능
- 노선 및 버스 현 위치 파악 : 버스를 선택하고, 지도 위에 표시된 해당 버스의 노선 위치 및 버스의 현 위치를 확인하는 기능
- 예약 : 버스 정보를 수신하여 예약할 버스를 선택하고 예약 값을 DB로 전송하는 기능
- 탑승 : 버스에 설치된 NFC를 통해 NFC 고유 값을 수신한 뒤 탑승 정보를 DB에 저장하며 탑승하는 기능
- 예약 확인 및 취소 : 예약 정보를 DB에서 수신하여 예약을 취소한 뒤 DB로 전송하여 DB정보를 수정하는 기능

공통 기능(회원, 관리자, 버스기사)
- 로그인 : 사용자가 작성한 ID/PW를 입력 받아 DB에 저장된 값과 비교한 후 제재 횟수를 비교하여 일정 횟수에 도달하지 않으면 로그인하는 기능
- 아이디/비밀번호 찾기 : ID/PW를 잊어버려 검색하는 경우 회원은 계명대학교 홈페이지로 연결하여 찾을 수 있으며, 버스기사는 별도로 UI를 통해 정보를 입력받고 DB와 일치하다면 변경 정보를 입력받아 DB의 정보가 변경된다.
- 회원가입 : 회원이 회원가입에 필요한 정보를 입력하고 DB에 송신하여 값을 비교 후 일치하면 해당 정보를 수신 받아 회원가입을 실행하는 기능
- 확인메시지 송출 : 전체적인 기능에서 오류 혹은 체크가 필요한 경우에 메시지를 화면에 송출하여 사용자가 확인하는 기능  
- 공지사항 확인 : 관리자가 작성한 공지사항을 DB에서 수신하여 확인하는 기능
	
버스기사 기능
- 건의 확인 : 회원이 작성한 건의 내용을 DB에서 수신하여 목록을 확인한다.
- 버스 선택 및 출발 : 버스 정보를 DB에서 수신하여 운행할 버스를 선택해 자신의 개인정보를 송신하여 DB에 저장하고 출발 시 주기적으로 GPS정보를 송·수신하는 기능
- 개인 정보 관리 : 버스기사가 패스워드와 휴대폰 번호를 변경할 수 있는 기능

관리자 기능
- 기능 테스트 : 회원 혹은 버스기사를 선택하여 관리자가 전체의 기능을 테스트 및 사용할 수 있는 기능
- DB 정보 확인 / 변경 : 학생 정보 관리, 버스 정보 관리, 기타 정보 관리들에서 각각의 관련된 DB 정보들을 변경 및 확인할 수 있는 기능

Server/DB
 - 데이터 수신 : App에서 수신한 데이터를 수신
 - 데이터 저장 : App에서 수신한 데이터를 Server내의 DB에 저장
 - 데이터 전송 : App에서 요청한 데이터를 Server내의 DB에서 조건에 맞게 수집하여 App으로 전송

NFC
 - 데이터 전송 : App에서 NFC와 스캔하면 NFC의 고유 번호를 App으로 전송  

!!자세한 내용 및 전체적인 내용은 깃허브 내의 한글파일(가람조 캡스톤디자인 스행결과보고서)을 참조부탁드립니다.!!
