/**
 * ===================================================
 * JCommon-Serializer : a free serialization framework
 * ===================================================
 *
 * Project Info:  http://reporting.pentaho.org/jcommon-serializer/
 *
 * (C) Copyright 2006-2008, by Object Refinery Limited, Pentaho Corporation and Contributors.
 *
 * This library is free software; you can redistribute it and/or modify it under the terms
 * of the GNU Lesser General Public License as published by the Free Software Foundation;
 * either version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this
 * library; if not, write to the Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA 02111-1307, USA.
 *
 * [Java is a trademark or registered trademark of Sun Microsystems, Inc.
 * in the United States and other countries.]
 *
 * ------------
 * JCommonSerializerBoot
 * ------------
 */
package org.jfree.serializer;

import org.pentaho.reporting.libraries.base.boot.AbstractBoot;
import org.pentaho.reporting.libraries.base.config.Configuration;
import org.pentaho.reporting.libraries.base.versioning.ProjectInformation;

/**
 * The boot class guarantees a controlled initialization of the library.
 *
 * @author Thomas Morgner
 */
public class JCommonSerializerBoot extends AbstractBoot
{
  private static JCommonSerializerBoot instance;

  /**
   * Returns a singleton instance of the boot class.
   *
   * @return the singleton booter.
   */
  public static synchronized JCommonSerializerBoot getInstance()
  {
    if (instance == null)
    {
      instance = new JCommonSerializerBoot();
    }
    return instance;
  }

  /**
   * Private constructor to prevent object creation.
   */
  private JCommonSerializerBoot()
  {
  }

  /**
   * Loads the configuration. This will be called exactly once.
   *
   * @return The configuration.
   */
  protected Configuration loadConfiguration()
  {
    return createDefaultHierarchicalConfiguration
            ("/org/jfree/serializer/jcommon-serializer.properties",
             "/jcommon-serializer.properties", true, JCommonSerializerBoot.class);
  }

  /**
   * Performs the boot. This method is empty, as this library does not require any manual initializations. 
   */
  protected void performBoot()
  {

  }

  /**
   * Returns the project info.
   *
   * @return The project info.
   */
  protected ProjectInformation getProjectInfo()
  {
    return JCommonSerializerInfo.getInstance();
  }
}
