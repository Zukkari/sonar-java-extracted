/*
 * SonarQube Java
 * Copyright (C) 2012-2019 SonarSource SA
 * mailto:info AT sonarsource DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package io.github.zukkari.sonar.java.model.expression;

import com.google.common.collect.Lists;
import io.github.zukkari.sonar.java.model.AbstractTypedTree;
import io.github.zukkari.sonar.java.model.InternalSyntaxToken;
import org.sonar.plugins.java.api.tree.ExpressionTree;
import org.sonar.plugins.java.api.tree.InstanceOfTree;
import org.sonar.plugins.java.api.tree.SyntaxToken;
import org.sonar.plugins.java.api.tree.Tree;
import org.sonar.plugins.java.api.tree.TreeVisitor;
import org.sonar.plugins.java.api.tree.TypeTree;

public class InstanceOfTreeImpl extends AbstractTypedTree implements InstanceOfTree {

  private ExpressionTree expression;
  private final InternalSyntaxToken instanceofToken;
  private final TypeTree type;

  public InstanceOfTreeImpl(InternalSyntaxToken instanceofToken, TypeTree type) {
    super(Kind.INSTANCE_OF);
    this.instanceofToken = instanceofToken;
    this.type = type;
  }

  public InstanceOfTreeImpl complete(ExpressionTree expression) {
    this.expression = expression;
    return this;
  }

  @Override
  public Kind kind() {
    return Kind.INSTANCE_OF;
  }

  @Override
  public ExpressionTree expression() {
    return expression;
  }

  @Override
  public SyntaxToken instanceofKeyword() {
    return instanceofToken;
  }

  @Override
  public TypeTree type() {
    return type;
  }

  @Override
  public void accept(TreeVisitor visitor) {
    visitor.visitInstanceOf(this);
  }

  @Override
  public Iterable<Tree> children() {
    return Lists.newArrayList(
      expression,
      instanceofToken,
      type
    );
  }

}
