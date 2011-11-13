/*
 * Copyright (C) 2011 eXo Platform SAS.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.juzu.impl.processor;

/** @author <a href="mailto:julien.viet@exoplatform.com">Julien Viet</a> */
enum ErrorCode
{

   CANNOT_WRITE_CONFIG,

   CANNOT_WRITE_APPLICATION_CONFIG,

   CONTROLLER_METHOD_NOT_FOUND,

   CANNOT_WRITE_TEMPLATE,

   CANNOT_WRITE_CONTROLLER_CLASS,

   CANNOT_WRITE_TEMPLATE_STUB_CLASS,

   CANNOT_WRITE_QUALIFIED_TEMPLATE_CLASS,

   CANNOT_WRITE_APPLICATION_CLASS,

   DUPLICATE_CONTROLLER_ID,

   TEMPLATE_NOT_FOUND,

   TEMPLATE_SYNTAX_ERROR,

   ILLEGAL_PATH


}