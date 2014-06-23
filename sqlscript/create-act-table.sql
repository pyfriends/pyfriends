CREATE TABLE activities (
  activityid INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  userid INT UNSIGNED NOT NULL,
  activityname CHAR(64) NOT NULL,
  activityowner CHAR(16) NOT NULL,
  activitycontact CHAR(64) NOT NULL,
  activitytype ENUM('�Ժ�����̨', 
                    '�ӱ������',
                    '��������Է',
                    '�����˶���',
                    '��Ҫ����',
                    '���α���',
                    'ѧ��ȥ�Ķ���',
                    '�����Ӱ�') 
               NOT NULL,
  activitypos CHAR(64) NOT NULL,
  acttimebeg DATETIME NOT NULL,
  acttimeend DATETIME NOT NULL,
  actmaxnumber INT UNSIGNED NOT NULL,
  acttakenumber INT UNSIGNED NOT NULL,
  activityrange ENUM('ѧ��', '����') NOT NULL,
  activitydetail TEXT NOT NULL
);

CREATE TABLE activities_activitystatus (
  activityid INT UNSIGNED NOT NULL PRIMARY KEY,
  activitystatus ENUM('valid', 'not-valid') NOT NULL
);

CREATE TABLE activities_actabs (
  activityid INT UNSIGNED NOT NULL PRIMARY KEY,
  actabs TEXT NOT NULL
);
