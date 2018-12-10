# maven 学习

## 一个简单文件pom文件
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.zxiaoyao.mvn</groupId>
    <artifactId>hello-world</artifactId>
    <version>1.0.-SNAPSHOT</version>
    <name>Maven Hello World Project</name>
    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>
    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.11</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>RELEASE</version>
        </dependency>

    </dependencies>

    <build>
        <plugins>
            <!-- 在meta-inf文件夹的 manifest中加入主执行类 -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-shade-plugin</artifactId>
                <version>3.0.0</version>
                <!--避免生成 dependencyReducePom文件 -->
                <configuration>
                    <createDependencyReducedPom>false</createDependencyReducedPom>
                </configuration>
                <executions>
                    <execution>
                        <phase>package</phase>
                        <goals>
                            <goal>shade</goal>
                        </goals>
                        <configuration>
                            <transformers>
                                <transformer implementation="org.apache.maven.plugins.shade.resource.ManifestResourceTransformer">
                                    <mainClass>com.zxiaoyao.mvn.helloworld.HelloWorld</mainClass>
                                </transformer>

                            </transformers>
                        </configuration>
                    </execution>
                </executions>
            </plugin>

        </plugins>

    </build>

</project>
```

## 使用Archetype生成项目骨架
maven项目中有一些约定，例如 Hello World 项目中约定：在项目的根目录中放置pom.xml，在src/main/java目录中放置项目的主代码，在src/test/java中放置测试代码。
这些基本的文件结构和pom.xml文件内容称为项目的骨架。

使用 mvn archetype:generate 创建maven骨架
```text
E:\workspaces\grow-mvn>mvn archetype:generate
[INFO] Scanning for projects...
Downloading from alimaven: http://maven.aliyun.com/nexus/content/repositories/central/org/apache/maven/plugins/maven-archetype-plugin/maven-metadata.xml
...
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building Maven Stub Project (No POM) 1
[INFO] ------------------------------------------------------------------------
[INFO]
[INFO] >>> maven-archetype-plugin:3.0.1:generate (default-cli) > generate-sources @ standalone-pom >>>
[INFO]
[INFO] <<< maven-archetype-plugin:3.0.1:generate (default-cli) < generate-sources @ standalone-pom <<<
[INFO]
[INFO]
[INFO] --- maven-archetype-plugin:3.0.1:generate (default-cli) @ standalone-pom ---
[INFO] Generating project in Interactive mode
[WARNING] No archetype found in remote catalog. Defaulting to internal catalog
[INFO] No archetype defined. Using maven-archetype-quickstart (org.apache.maven.archetypes:maven-archetype-quickstart:1.0)
Choose archetype:
1: internal -> org.apache.maven.archetypes:maven-archetype-archetype (An archetype which contains a sample archetype.)
2: internal -> org.apache.maven.archetypes:maven-archetype-j2ee-simple (An archetype which contains a simplifed sample J2EE application.)
3: internal -> org.apache.maven.archetypes:maven-archetype-plugin (An archetype which contains a sample Maven plugin.)
4: internal -> org.apache.maven.archetypes:maven-archetype-plugin-site (An archetype which contains a sample Maven plugin site.
      This archetype can be layered upon an existing Maven plugin project.)
5: internal -> org.apache.maven.archetypes:maven-archetype-portlet (An archetype which contains a sample JSR-268 Portlet.)
6: internal -> org.apache.maven.archetypes:maven-archetype-profiles ()
7: internal -> org.apache.maven.archetypes:maven-archetype-quickstart (An archetype which contains a sample Maven project.)
8: internal -> org.apache.maven.archetypes:maven-archetype-site (An archetype which contains a sample Maven site which demonstrates
      some of the supported document types like APT, XDoc, and FML and demonstrates how
      to i18n your site. This archetype can be layered upon an existing Maven project.)
9: internal -> org.apache.maven.archetypes:maven-archetype-site-simple (An archetype which contains a sample Maven site.)
10: internal -> org.apache.maven.archetypes:maven-archetype-webapp (An archetype which contains a sample Maven Webapp project.)
Choose a number or apply filter (format: [groupId:]artifactId, case sensitive contains): 7:
Downloading from alimaven: http://maven.aliyun.com/nexus/content/repositories/central/org/apache/maven/archetypes/maven-archetype-quickstart/1.1/maven-archetype-quickstart-1.1.pom
....
Define value for property 'artifactId': hello-world-1
Define value for property 'version' 1.0-SNAPSHOT: : 1.0-SNAPSHOT
Define value for property 'package' com.zxiaoyao.mvn: :
Confirm properties configuration:
groupId: com.zxiaoyao.mvn
artifactId: hello-world-1
version: 1.0-SNAPSHOT
package: com.zxiaoyao.mvn
 Y: :
[INFO] ----------------------------------------------------------------------------
[INFO] Using following parameters for creating project from Old (1.x) Archetype: maven-archetype-quickstart:1.1
[INFO] ----------------------------------------------------------------------------
[INFO] Parameter: basedir, Value: E:\workspaces\grow-mvn
[INFO] Parameter: package, Value: com.zxiaoyao.mvn
[INFO] Parameter: groupId, Value: com.zxiaoyao.mvn
[INFO] Parameter: artifactId, Value: hello-world-1
[INFO] Parameter: packageName, Value: com.zxiaoyao.mvn
[INFO] Parameter: version, Value: 1.0-SNAPSHOT
[INFO] project created from Old (1.x) Archetype in dir: E:\workspaces\grow-mvn\hello-world-1
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 01:31 min
[INFO] Finished at: 2018-12-10T10:23:03+08:00
[INFO] Final Memory: 17M/140M
[INFO] ------------------------------------------------------------------------

```
