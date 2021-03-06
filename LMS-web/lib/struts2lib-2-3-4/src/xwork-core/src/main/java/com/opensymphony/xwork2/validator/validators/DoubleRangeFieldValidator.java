/*
 * Copyright 2002-2006,2009 The Apache Software Foundation.
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

package com.opensymphony.xwork2.validator.validators;

import com.opensymphony.xwork2.validator.ValidationException;

/**
 * <!-- START SNIPPET: javadoc -->
 * Field Validator that checks if the double specified is within a certain range.
 * <!-- END SNIPPET: javadoc -->
 *
 *
 * <!-- START SNIPPET: parameters -->
 * <ul>
 *     <li>fieldName - The field name this validator is validating. Required if using Plain-Validator Syntax otherwise not required</li>
 *     <li>minInclusive - the minimum inclusive value in FloatValue format specified by Java language (if none is specified, it will not be checked) </li>
 *     <li>maxInclusive - the maximum inclusive value in FloatValue format specified by Java language (if none is specified, it will not be checked) </li>
 *     <li>minExclusive - the minimum exclusive value in FloatValue format specified by Java language (if none is specified, it will not be checked) </li>
 *     <li>maxExclusive - the maximum exclusive value in FloatValue format specified by Java language (if none is specified, it will not be checked) </li>
 *     <li>minInclusiveExpression - the minimum inclusive value specified as a OGNL expression (if none is specified, it will not be checked) </li>
 *     <li>maxInclusiveExpression - the maximum inclusive value specified as a OGNL expression (if none is specified, it will not be checked) </li>
 *     <li>minExclusiveExpression - the minimum exclusive value specified as a OGNL expression (if none is specified, it will not be checked) </li>
 *     <li>maxExclusiveExpression - the maximum exclusive value specified as a OGNL expression (if none is specified, it will not be checked) </li>
 * </ul>
 *
 * You can specify either minInclusive, maxInclusive, minExclusive and maxExclusive or minInclusiveExpression, maxInclusiveExpression,
 * minExclusiveExpression and maxExclusiveExpression as a OGNL expression, see example below. You can always try to mix params
 * but be aware that such behaviour was not tested.
 * <!-- END SNIPPET: parameters -->
 *
 *
 * <!-- START SNIPPET: parameters-warning -->
 * Do not use ${minInclusiveExpression}, ${maxInclusiveExpression}, ${minExclusiveExpressionExpression} and ${maxExclusive}
 * as an expression as this will turn into infinitive loop!
 * <!-- END SNIPPET: parameters-warning -->
 *
 *
 * <pre>
 * <!-- START SNIPPET: examples -->
 * &lt;validators>
 *     &lt;!-- Plain Validator Syntax --&gt;
 *         &lt;validator type="double">
 *         &lt;param name="fieldName"&gt;percentage&lt;/param&gt;
 *         &lt;param name="minInclusive"&gt;20.1&lt;/param&gt;
 *         &lt;param name="maxInclusive"&gt;50.1&lt;/param&gt;
 *         &lt;message&gt;Age needs to be between ${minInclusive} and ${maxInclusive} (inclusive)&lt;/message&gt;
 *     &lt;/validator&gt;
 *
 *     &lt;!-- Field Validator Syntax --&gt;
 *     &lt;field name="percentage"&gt;
 *         &lt;field-validator type="double"&gt;
 *             &lt;param name="minExclusive"&gt;0.123&lt;/param&gt;
 *             &lt;param name="maxExclusive"&gt;99.98&lt;/param&gt;
 *             &lt;message&gt;Percentage needs to be between ${minExclusive} and ${maxExclusive} (exclusive)&lt;/message&gt;
 *         &lt;/field-validator&gt;
 *     &lt;/field&gt;
 *
 *     &lt;!-- Field Validator Syntax with expression --&gt;
 *     &lt;field name="percentage"&gt;
 *         &lt;field-validator type="double"&gt;
 *             &lt;param name="minExclusiveExpression"&gt;${minExclusiveValue}&lt;/param&gt; &lt;!-- will be evaluated as: Double getMinExclusiveValue() --&gt;
 *             &lt;param name="maxExclusiveExpression"&gt;${maxExclusiveValue}&lt;/param&gt; &lt;!-- will be evaluated as: Double getMaxExclusiveValue() --&gt;
 *             &lt;message&gt;Percentage needs to be between ${minExclusive} and ${maxExclusive} (exclusive)&lt;/message&gt;
 *         &lt;/field-validator&gt;
 *     &lt;/field&gt;
 * &lt;/validators&gt;
 * <!-- END SNIPPET: examples -->
 * </pre>
 *
 * @author Rainer Hermanns
 * @author Rene Gielen
 *
 * @version $Id: DoubleRangeFieldValidator.java 1431115 2013-01-09 22:21:56Z lukaszlenart $
 */
public class DoubleRangeFieldValidator extends FieldValidatorSupport {
    
    private Double maxInclusive = null;
    private Double minInclusive = null;
    private Double minExclusive = null;
    private Double maxExclusive = null;

    public void validate(Object object) throws ValidationException {
        String fieldName = getFieldName();
        Double value;
        try {
            Object obj = this.getFieldValue(fieldName, object);
            if (obj == null) {
                return;
            }
            value = Double.valueOf(obj.toString());
        } catch (NumberFormatException e) {
            return;
        }

        if ((maxInclusive != null && value.compareTo(maxInclusive) > 0) ||
                (minInclusive != null && value.compareTo(minInclusive) < 0) ||
                (maxExclusive != null && value.compareTo(maxExclusive) >= 0) ||
                (minExclusive != null && value.compareTo(minExclusive) <= 0)) {
            addFieldError(fieldName, object);
        }
    }

    public void setMaxInclusive(Double maxInclusive) {
        this.maxInclusive = maxInclusive;
    }

    public Double getMaxInclusive() {
        return maxInclusive;
    }

    public void setMinInclusive(Double minInclusive) {
        this.minInclusive = minInclusive;
    }

    public Double getMinInclusive() {
        return minInclusive;
    }

    public Double getMinExclusive() {
        return minExclusive;
    }

    public void setMinExclusive(Double minExclusive) {
        this.minExclusive = minExclusive;
    }

    public Double getMaxExclusive() {
        return maxExclusive;
    }

    public void setMaxExclusive(Double maxExclusive) {
        this.maxExclusive = maxExclusive;
    }

    public void setMinInclusiveExpression(String minInclusiveExpression) {
        this.minInclusive = (Double) parse(minInclusiveExpression, Double.class);
    }

    public void setMaxInclusiveExpression(String maxInclusiveExpression) {
        this.maxInclusive = (Double) parse(maxInclusiveExpression, Double.class);
    }

    public void setMinExclusiveExpression(String minExclusiveExpression) {
        this.minExclusive = (Double) parse(minExclusiveExpression, Double.class);
    }

    public void setMaxExclusiveExpression(String maxExclusiveExpression) {
        this.maxExclusive = (Double) parse(maxExclusiveExpression, Double.class);
    }

}
