Twitter crypto sentiment analysis for algo trading
A)Requirement
1)Consume twitter topic 'tweet' which has json encoded tweets
	1.1)Json encoded means the structure of tweet is in json
	1.2)But kafka stores them as byte array, hence we need some mechanism to deserialize these messages to json and json to class objects.
#2)Filter out those tweets which does not have any type of crypto mention - we need sentiment analysis of tweet hence dropping this filter in code
3)Filter out those which are retweets
4)Tweets can be in multiple languages English and Non-English
	4.1)Create branch and pass english to different branch and non-english to different branch
	4.2)In non-english branch , convert value to englsh value using languageClient
	4.3)Merge both the branches in 'translatedStream'
5)Identify the behaviour of  sentiment  , whether its positive or its negative.
	5.1)if record value contains more than one cryptos, then use flatmapvalues to create multiple record values and find sentiment for all
6)Based on positivity pass only those record values to 'crypto-sentiment'

B)How to run kafka cluster
1)Download docker desktop
2)Run :docker-compose up in dir /src/main/resources
3)Enter kafka container :docker exec -it 'name of container set in docker-compose.yml file' /bin/bash
	3.1)After 2) kafka cluster will show up in docker dashboard, we can click on open cli to enter kafka docker container
	3.2)The volume type bind in docker-compose.yaml will put file from host to inside of container, hence dummytweets.json will be available in 	container
4)Run below command to consume and produce messages: needs to be run from inside of container
	 4.1)kafka-console-consumer --bootstrap-server localhost:9092 --topic tweets
	 4.2)Run this in dir /opt because tweets.json is mapped at opt dir. in container : kafka-console-producer --bootstrap-server localhost:9092 		--topic tweets < tweets.json

C)How to run the code
1)created task for each version of code, just run gradle 'version no'

How to generate Avro Class
1)Define .avsc file in src/main/avro package and running gradlew build will generate java class in build/generated-main-avro-java package
2)This generation of class file happens because of plugin that we added in gradle build script

D)VersionNo
1)Run basic kafka cluster and run this app using 'gradlew runV1'. Then run B.4.2) to produce tweets.
	1.1)If we dont use serdes in config properties kafka will send messages in byte[] format
2)Using Custom Serializer/Deserializer and registering it as Serdes so that we can convert bytearray to Tweet that represents a record.
3)Using filter operator , filter retweets
4)Branching
5)tranlsating and merging
6)Because of the flatmapvalues, each tweet will create multiple entitysentiment based on no. of sentiments it contains.
7)Using gson we serialized EntitySentiment to Json to bytearray and pushed to different topic 'crypto-sentiment'.
	7.1)Produce 3 tweets from tweet.json and on consuming from crypto-sentiment you will see 1 record each for bitcoin and ethereum
