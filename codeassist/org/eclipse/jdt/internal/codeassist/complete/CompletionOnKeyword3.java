/*******************************************************************************
 * Copyright (c) 2000, 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.jdt.internal.codeassist.complete;

import org.eclipse.jdt.internal.compiler.ast.SingleNameReference;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;

public class CompletionOnKeyword3 extends SingleNameReference implements CompletionOnKeyword{
	private char[][] possibleKeywords;
	public CompletionOnKeyword3(char[] token, long pos, char[] possibleKeyword) {
		this(token, pos, new char[][]{possibleKeyword});
	}
	public CompletionOnKeyword3(char[] token, long pos, char[][] possibleKeywords) {
		super(token, pos);
		this.token = token;
		this.possibleKeywords = possibleKeywords;
	}
	public char[] getToken() {
		return token;
	}
	public char[][] getPossibleKeywords() {
		return possibleKeywords;
	}
	public StringBuffer printExpression(int indent, StringBuffer output) {
		
		return output.append("<CompleteOnKeyword:").append(token).append('>'); //$NON-NLS-1$
	}
	public TypeBinding resolveType(BlockScope scope) {
		throw new CompletionNodeFound(this, scope);
	}
}
