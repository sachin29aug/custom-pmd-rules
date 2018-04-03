package org.baeldung.pmd;

import net.sourceforge.pmd.lang.java.ast.ASTClassOrInterfaceDeclaration;
import net.sourceforge.pmd.lang.java.rule.AbstractJavaRule;

public class UnitTestNamingConventionRule extends AbstractJavaRule {

	public Object visit(ASTClassOrInterfaceDeclaration node, Object data) {
		
		String className = node.getImage();
		if (className != null && className.endsWith("Test")) {
			System.out.println("Applying UnitTestNamingConventionRule to test - " + className);

			if (!className.endsWith("IntegrationTest") && !className.endsWith("LongRunningUnitTest")
					&& !className.endsWith("ManualTest") && !className.endsWith("JdbcTest")
					&& !className.endsWith("LiveTest")) {
				addViolation(data, node);
			}
		}
		
		return data;
	}
}