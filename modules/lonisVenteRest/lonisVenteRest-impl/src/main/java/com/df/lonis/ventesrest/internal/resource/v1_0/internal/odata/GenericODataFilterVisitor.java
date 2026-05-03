package com.df.lonis.ventesrest.internal.resource.v1_0.internal.odata;

import com.liferay.portal.odata.filter.expression.BinaryExpression;
import com.liferay.portal.odata.filter.expression.Expression;
import com.liferay.portal.odata.filter.expression.ExpressionVisitException;
import com.liferay.portal.odata.filter.expression.ExpressionVisitor;
import com.liferay.portal.odata.filter.expression.ListExpression;
import com.liferay.portal.odata.filter.expression.LiteralExpression;
import com.liferay.portal.odata.filter.expression.MemberExpression;
import com.liferay.portal.odata.filter.expression.MethodExpression;
import com.liferay.portal.odata.filter.expression.PropertyExpression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Visiteur OData generique. Capture toutes les contraintes (eq, ne, ge, gt, le,
 * lt, contains, startswith) sous forme de liste de Criterion neutres
 * exploitables par {@link ODataFilterApplier}.
 *
 * @author HP
 */
public class GenericODataFilterVisitor
	implements ExpressionVisitor<Object> {

	public static class Criterion {

		public final String field;
		public final Op op;
		public final String rawValue;

		public Criterion(String field, Op op, String rawValue) {
			this.field = field;
			this.op = op;
			this.rawValue = rawValue;
		}

	}

	public enum Op {

		CONTAINS, EQ, GE, GT, LE, LT, NE, STARTSWITH

	}

	public List<Criterion> getCriteria() {
		return _criteria;
	}

	@Override
	public Object visitBinaryExpressionOperation(
			BinaryExpression.Operation operation, Object left, Object right)
		throws ExpressionVisitException {

		if (operation == BinaryExpression.Operation.AND) {
			return null;
		}
		if (operation == BinaryExpression.Operation.OR) {
			return null;
		}

		if ((left == null) || (right == null)) {
			return null;
		}

		String field = String.valueOf(left);
		String value = String.valueOf(right);

		Op op = _toOp(operation);

		if (op != null) {
			_criteria.add(new Criterion(field, op, value));
		}

		return null;
	}

	@Override
	public Object visitListExpressionOperation(
		ListExpression.Operation operation, Object left, List<Object> right) {

		return null;
	}

	@Override
	public Object visitLiteralExpression(LiteralExpression literalExpression) {
		String text = literalExpression.getText();

		if (text == null) {
			return null;
		}

		// retire les apostrophes englobantes des litteraux string
		if ((text.length() >= 2) && text.startsWith("'") &&
			text.endsWith("'")) {

			return text.substring(1, text.length() - 1);
		}

		return text;
	}

	@Override
	public Object visitMemberExpression(MemberExpression memberExpression)
		throws ExpressionVisitException {

		Expression inner = memberExpression.getExpression();

		if (inner instanceof PropertyExpression) {
			return ((PropertyExpression)inner).getName();
		}
		if (inner != null) {
			return inner.accept(this);
		}
		return null;
	}

	@Override
	public Object visitMethodExpression(
		List<Object> args, MethodExpression.Type type) {

		if (args.size() < 2) {
			return null;
		}

		String field = String.valueOf(args.get(0));
		String value = String.valueOf(args.get(1));

		Op op = null;

		if (type == MethodExpression.Type.CONTAINS) {
			op = Op.CONTAINS;
		}
		else if (type == MethodExpression.Type.STARTS_WITH) {
			op = Op.STARTSWITH;
		}

		if (op != null) {
			_criteria.add(new Criterion(field, op, value));
		}

		return null;
	}

	private Op _toOp(BinaryExpression.Operation operation) {
		Op op = _MAP.get(operation);
		return op;
	}

	private static final Map<BinaryExpression.Operation, Op> _MAP =
		new HashMap<>();

	static {
		_MAP.put(BinaryExpression.Operation.EQ, Op.EQ);
		_MAP.put(BinaryExpression.Operation.NE, Op.NE);
		_MAP.put(BinaryExpression.Operation.GE, Op.GE);
		_MAP.put(BinaryExpression.Operation.GT, Op.GT);
		_MAP.put(BinaryExpression.Operation.LE, Op.LE);
		_MAP.put(BinaryExpression.Operation.LT, Op.LT);
	}

	private final List<Criterion> _criteria = new ArrayList<>();

}
