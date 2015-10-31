/*******************************************************************************
 * Copyright 2015 See AUTHORS file.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package com.mygdx.game.pathfinding;

import com.badlogic.gdx.ai.pfa.Connection;
import com.badlogic.gdx.ai.pfa.indexed.IndexedNode;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

/**
 * @author jsjolund
 */
public class Triangle implements IndexedNode<Triangle> {

	public int triIndex;
	public int meshPartIndex;
	public Vector3 a;
	public Vector3 b;
	public Vector3 c;
	public Vector3 centroid;
	public Array<Connection<Triangle>> connections;

	public Triangle(Vector3 a, Vector3 b, Vector3 c, int triIndex, int meshPartIndex) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.triIndex = triIndex;
		this.meshPartIndex = meshPartIndex;
		this.centroid = new Vector3(a).add(b).add(c).scl(1f / 3f);
		this.connections = new Array<Connection<Triangle>>();
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Triangle{");
		sb.append("triIndex=").append(triIndex);
		sb.append(", meshPartIndex=").append(meshPartIndex);
		sb.append('}');
		return sb.toString();
	}

	@Override
	public int getIndex() {
		return triIndex;
	}

	@Override
	public Array<Connection<Triangle>> getConnections() {
		return connections;
	}
}

