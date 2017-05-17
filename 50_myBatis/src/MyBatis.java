import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatis {

	// mybatis.xml ��ġ

	private final static String RESOURCE = "mybatis/mybatis.xml";

	private static SqlSessionFactory sqlMapper = null;

	// MyBatis �������丮�� ��� �޼ҵ�

	public 
 SqlSessionFactory getSqlSessionFactory() {

		if (sqlMapper == null) {

			Reader reader;

			try {

				// mybatis.xml �ڿ��� ��´�.

				reader = Resources.getResourceAsReader(RESOURCE);

				sqlMapper = new SqlSessionFactoryBuilder().build(reader);

			} catch (IOException e) {

				e.printStackTrace();

			}

		}

		return sqlMapper;

	}

}



