/*
 * Copyright (C) 2008 feilong
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.feilong.core.lang;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.Validate;

import com.feilong.core.Validator;

/**
 * {@link Object} 工具类.
 * 
 * <h3>判断相等</h3>
 * 
 * <blockquote>
 * <ol>
 * <li>{@link org.apache.commons.lang3.ObjectUtils#equals(Object, Object)} 支持两个值都是null的情况</li>
 * <li>{@link java.util.Objects#equals(Object, Object)} 也支持两个值都是null的情况</li>
 * </ol>
 * </blockquote>
 *
 * @author <a href="http://feitianbenyue.iteye.com/">feilong</a>
 * @see org.apache.commons.lang3.ObjectUtils
 * @see java.util.Objects
 * @since 1.0.0
 */
public final class ObjectUtil{

    /** Don't let anyone instantiate this class. */
    private ObjectUtil(){
        //AssertionError不是必须的. 但它可以避免不小心在类的内部调用构造器. 保证该类在任何情况下都不会被实例化.
        //see 《Effective Java》 2nd
        throw new AssertionError("No " + getClass().getName() + " instances for you!");
    }

    /**
     * 如果 <code>object</code> 是null或者empty,返回 默认值 <code>defaultValue</code>.
     * 
     * <p>
     * {@link ObjectUtils#defaultIfNull(Object, Object)} 只判断null的情况
     * </p>
     *
     * <pre>
     * ObjectUtil.defaultIfNullOrEmpty(null, null)      = null
     * ObjectUtil.defaultIfNullOrEmpty(null, "")        = ""
     * ObjectUtil.defaultIfNullOrEmpty(null, "zz")      = "zz"
     * ObjectUtil.defaultIfNullOrEmpty("abc", *)        = "abc"
     * ObjectUtil.defaultIfNullOrEmpty(Boolean.TRUE, *) = Boolean.TRUE
     * </pre>
     *
     * @param <T>
     *            the type of the object
     * @param object
     *            the {@code Object} to test, may be {@code null}
     * @param defaultValue
     *            the default value to return, may be {@code null}
     * @return 如果 <code>object</code> 是null或者empty,返回 <code>defaultValue</code><br>
     *         否则返回 <code>object</code>
     * @see org.apache.commons.lang3.ObjectUtils#defaultIfNull(Object, Object)
     * @since 1.7.2
     */
    public static <T> T defaultIfNullOrEmpty(final T object,final T defaultValue){
        return Validator.isNotNullOrEmpty(object) ? object : defaultValue;
    }

    /**
     * 判断指定的对象 <code>object</code>是不是 {@link Boolean} 类型数据.
     * 
     * @param object
     *            对象
     * @return 是返回true <br>
     *         如果 <code>object</code> 是null,返回false
     */
    public static boolean isBoolean(Object object){
        return object instanceof Boolean;
    }

    /**
     * 判断指定的对象 <code>object</code>是不是{@link Integer}类型.
     * 
     * @param object
     *            对象
     * @return 是返回true <br>
     *         如果 <code>object</code> 是null,返回false
     */
    public static boolean isInteger(Object object){
        return object instanceof Integer;
    }

    /**
     * 判断指定的对象 <code>object</code>是否是数组.
     * 
     * <h3><code>instanceof</code>和 {@link java.lang.Class#isArray()}的区别:</h3>
     * 
     * <blockquote>
     * <p>
     * 
     * In general, use the instanceof operator to test whether an object is an array.<br>
     * 
     * At the JVM level, the instanceof operator translates to a specific "instanceof" byte code, which is highly optimized in most JVM
     * implementations.<br>
     * </p>
     * 
     * <p>
     * The reflective approach (getClass().isArray()) is compiled to two separate "invokevirtual" instructions. The more generic
     * optimizations applied by the JVM to these may not be as fast as the hand-tuned optimizations inherent in the "instanceof"
     * instruction.<br>
     * </p>
     * 
     * 
     * <p>
     * 有两种特殊情况: null references 和 references to primitive arrays.<br>
     * 
     * A null reference will cause instanceof to result false, while the isArray throws a NullPointerException.<br>
     * </p>
     * 
     * <p>
     * Applied to a primitive array, the instanceof results false, but the isArray returns true.
     * </p>
     * </blockquote>
     *
     * @param object
     *            the object
     * @return true, if checks if is array<br>
     *         如果 <code>object</code> 是null,抛出 {@link NullPointerException}<br>
     * @see <a href="http://stackoverflow.com/questions/219881/java-array-reflection-isarray-vs-instanceof">Java array reflection: isArray
     *      vs. instanceof</a>
     * @see <a href="http://stackoverflow.com/questions/2725533/how-to-see-if-an-object-is-an-array-without-using-reflection">How to see if
     *      an object is an array without using reflection?</a>
     * @since 1.3.0
     */
    public static boolean isArray(Object object){
        Validate.notNull(object, "object can't be null!");
        return object.getClass().isArray();
    }
}
