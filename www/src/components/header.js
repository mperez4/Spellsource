import React from 'react'
import PostLink from './post-link'
import { useStaticQuery, graphql, Link } from 'gatsby'
import Img from 'gatsby-image'
import styles from './creative-layout.module.scss'
import Search from './search'

const Header = () => {
  const data = useStaticQuery(graphql`
  query {
    headerImage: file(relativePath: { eq: "assets/icon.png" }) {
      id
      childImageSharp {
        fixed(width: 25) {
          ...GatsbyImageSharpFixed
        }
      }
    }
    allMarkdownRemark(sort: { order: DESC, fields: [frontmatter___date] }) {
      edges {
        node {
          id
          excerpt(pruneLength: 250)
          frontmatter {
            date(formatString: "MMMM DD, YYYY")
            path
            title
            header
          }
        }
      }
    }
  }
`)

  const pages = data.allMarkdownRemark.edges
    .filter(edge => !!edge.node.frontmatter.header)
    .map(edge => <li key={edge.node.id}><PostLink post={edge.node}/></li>)

  return <header>
    <div className={styles.menu}>
      <ul>
        <li key={data.headerImage.id}><Link to='/'><Img fixed={data.headerImage.childImageSharp.fixed}/></Link></li>
        <li key={'javadocs'}><a href='/javadoc'>[Docs]</a></li>
        {pages}
        <li key={'download'}><a href='/download'>[Play Now]</a></li>
        <li key={'search'}><Search placeholder={'Search'} /></li>
      </ul>
    </div>
  </header>
}

export default Header