CREATE TABLE activities (
  activityid INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  userid INT UNSIGNED NOT NULL,
  activityname CHAR(64) NOT NULL,
  activityowner CHAR(16) NOT NULL,
  activitycontact CHAR(64) NOT NULL,
  activitytype ENUM('吃喝七里台', 
                    '从北洋出发',
                    '北洋文艺苑',
                    '激情运动场',
                    '我要换书',
                    '逸游北洋',
                    '学霸去哪儿了',
                    '杂七杂八') 
               NOT NULL,
  activitypos CHAR(64) NOT NULL,
  acttimebeg DATETIME NOT NULL,
  acttimeend DATETIME NOT NULL,
  actmaxnumber INT UNSIGNED NOT NULL,
  acttakenumber INT UNSIGNED NOT NULL,
  activityrange ENUM('学生', '任意') NOT NULL,
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
