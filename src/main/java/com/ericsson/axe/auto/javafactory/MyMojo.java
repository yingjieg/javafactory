package com.ericsson.axe.auto.javafactory;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.io.File;
import java.io.IOException;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JMod;

/**
 * Goal which touches a timestamp file.
 * 
 * @goal touch
 * 
 * @phase process-sources
 */
public class MyMojo extends AbstractMojo {
	/**
	 * Location of the file.
	 * 
	 * @parameter expression="${project.build.directory}"
	 * @required
	 */
	private String filePath;

	/**
	 * Location of main resources.
	 * 
	 * @parameter default-value="src/main/resources"
	 * @required
	 */
	private String resourceDirectory;

	public void execute() throws MojoExecutionException {

		JCodeModel cm = new JCodeModel();
		try {
			JDefinedClass dc = cm._class("y.gogo.sample.Zero");
			dc.field(JMod.PRIVATE, cm.parseType("String"), "unit");
//			dc.method(JMod.PUBLIC, cm.parseType("String"), "getUnit");

			cm.build(new File("src/main/java"));
		} catch (JClassAlreadyExistsException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
